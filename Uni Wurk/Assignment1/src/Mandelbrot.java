import java.util.List;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.EventHandler;

import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.canvas.Canvas;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;


/**
 * A class to represent Complex numbers.
 */
class Complex {

  /**
   * The real part.
   */
  private double real;

  /**
   * The imaginary part.
   */
  private double imag;

  public Complex() {
    this(0, 0);
  }

  public Complex(double _real, double _imag) {
    real = _real;
    imag = _imag;
  }

  /**
   * Addition of complex numbers.
   */
  public Complex addedTo(Complex c) {
    return new Complex(real + c.real, imag + c.imag);
  }

  /**
   * Multiplication of complex numbers.
   */
  public Complex multipliedBy(Complex c) {
    return new Complex(
        (real * c.real) - (imag * c.imag),
        (imag * c.real) + (real * c.imag)
      );
  }


  /**
   * Compute the Mandelbrot escape value: that is, how quickly we can determine
   * that the complex number is definitely not in the Mandelbrot set (lower
   * numbers mean more quickly). As a parameter, we give a degree of accuracy
   * to which we approximate the set.
   * 
   * @param maxEscape The number of iterations of the Mandelbrot formula after
   * which we are happy to conclude that the number probably is in the set.
   */
  public int getMandelbrotEscapeVal(int maxEscape) {

      Complex tmp = this;

      for (int i = 0; i < maxEscape; i++) {
          double real = tmp.real;
          double imag = tmp.imag;
          // If the square of the magnitude is greater than 4,
          // the number has escaped.
          if ((real * real) + (imag * imag) > 4.0)
            return i;
           
          // Compute the next iteration
          tmp = tmp.multipliedBy(tmp).addedTo(this);
      }

      return maxEscape;

  }

}

/**
 * The main application class.
 * 
 * This takes care of creating the window and adding the widgets.
 * For this application, there is only one widget: the canvas on which we
 * render the visualisation of the Mandelbrot set.
 */
public class Mandelbrot extends Application {

  // The canvas for displaying the visualisation
  private static MandelbrotCanvas canvas;

  /* Entry point of the program */
  public static void main(String[] args) {
  
    int num_threads = 1;
    if (args.length > 0) {
      num_threads = Integer.parseInt(args[0]);
    }

    // initialise the canvas
    canvas = new MandelbrotCanvas(num_threads);

    // Launch the application
    launch(args);
  }



  /**
   * This is the method that is called when the application is launched.
   * We can use it to initialise the GUI.
   * 
   * @param primaryStage The main stage of the GUI to which we can add widgets.
   */
  @Override
  public void start(Stage primaryStage) {

    Group root = new Group();
    Scene scene = new Scene(root, canvas.getWidth(), canvas.getHeight());
    root.getChildren().add(canvas);

    // Display the GUI
    primaryStage.setTitle("CS1812 Fractal Viewer");
    primaryStage.setScene(scene);
    primaryStage.show();

    autoZoom();

  }

  /**
   * This method simply creates a thread that zooms in 40 times, which is the
   * point to which we can approximate the Mandelbrot set using double precision
   * floating point numbers. Beyond this, we don't see any more detail.
   */
  private static void autoZoom() {
    Thread test =
      // Anonymous subclass of Thread
      new Thread () {
        public void run () {
          try {
            // Wait a bit for initial rendering of visualisation
            Thread.sleep(250);
            System.out.println("Running autoZoom");
            for (int i = 0; i < 40; i++) {
              // Zoom in (update the internal state of the canvas)
              canvas.zoomIn();
              // Compute the new visualisation
              Thread t = canvas.getRenderer();
              t.start();
              // Wait for that to finish
              t.join();
              // Wait a bit for it to be rendered to the GUI
              Thread.sleep(50);
            }
          }
          catch (InterruptedException e) {}
        }
      };
    // This means that the thread will not stop the JVM from exiting
    test.setDaemon(true);
    test.start();
  }

}

/**
 * This class represents a GUI widget that will display the visualisation of
 * the Mandelbrot set.
 * 
 * It extends the JavaFX class Canvas, which is what allows us to add it to the
 * GUI and call methods to affect how it appears on the screen.
 */
class MandelbrotCanvas extends Canvas {

  // The point in the place that this canvas centres on
  private double centreX = -0.7405485967893035;
  private double centreY = 0.1832072299209537;
  // private double centreX = -0.7425672465562819;
  // private double centreY = 0.13563626468181592;

  // The initial zoom level
  private static final double INIT_ZOOM = 0.005;

  // How much we zoom in or out each time
  private static final int zoomScale = 2;

  // The colour gradient that we will use to render the Mandelbrot set
  private static final Color[] gradient =
    new Color[] {
      Color.rgb(66,  30,  15),
      Color.rgb(25,  7,   26),
      Color.rgb(9,   1,   47),
      Color.rgb(4,   4,   73),
      Color.rgb(0,   7,   100),
      Color.rgb(12,  44,  138),
      Color.rgb(24,  82,  177),
      Color.rgb(57,  125, 209),
      Color.rgb(134, 181, 229),
      Color.rgb(211, 236, 248),
      Color.rgb(241, 233, 191),
      Color.rgb(248, 201, 95),
      Color.rgb(255, 170, 0),
      Color.rgb(204, 128, 0),
      Color.rgb(153, 87,  0),
      Color.rgb(106, 52,  3)
    };

  // The scale of magnification of this canvas.
  // Actually, the "width" of one pixel.
  private double pxScale = INIT_ZOOM;

  // The accuracy with which we will calculate the Mandelbrot set
  private int accuracy = 500;

  // The number of threads that will be used to compute the visualisation
  private int num_threads = 1;

  /**
   * This method updates the zoom level of this canvas, by zooming in one level
   * of magnification.
   */
  public void zoomIn () {
    this.pxScale /= zoomScale;
  }

  /**
   * This method updates the zoom level of this canvas, by zooming out one level
   * of magnification.
   */
  public void zoomOut () {
    this.pxScale *= zoomScale;
  }

  /**
   * Render the Mandelbrot set within the given rectangle in the given image
   * whose centre corresponds to the given point at the given scale of
   * magnification and with the given accuracy.
   * 
   * @param img The image to render upon.
   * @param centreX The x-coordinate of the plane that the image centres on.
   * @param centreY The y-coordinate of the plane that the image centres on.
   * @param scale The scale of magnification to render at.
   * @param rectangle The portion of the image to render.
   * @param accuracy The accuracy with which to compute the Mandelbrot set.
   */
  private static void render(
      WritableImage img,
      double centreX, double centreY,
      double scale,
      Rectangle rectangle,
      int accuracy)
  {
    // Calculate the real and imaginary components of the complex number
    // corresponding to the top left corner of the image
    double minX =
      centreX 
        - ((img.getWidth() / 2) * scale)
        - ((1 - (img.getWidth() % 2)) * scale * 0.5);
    double maxY =
      centreY
        + ((img.getHeight() / 2) * scale)
        + ((1 - (img.getHeight() % 2)) * scale * 0.5);

    // Get properties of the rectangle within which to render
    int x = (int) rectangle.getX();
    int y = (int) rectangle.getY();
    int width = (int) rectangle.getWidth();
    int height = (int) rectangle.getHeight();

    // The writer for rendering
    PixelWriter pw = img.getPixelWriter();

    // Now go through each pixel in the rectangle, computing its colour and
    // rendering it on the image.
    for (int dx = 0; dx < width; dx++) {
      for (int dy = 0; dy < height; dy++) {

        // Convert pixel to the corresponding complex number
        Complex p =
          new Complex(minX + ((x + dx) * scale), maxY - ((y + dy) * scale));

        // Calculate the escape value
        int escape_val = p.getMandelbrotEscapeVal(accuracy);

        // Colour for points probably in the Mandelbrot set
        Color c = Color.BLACK;

        // If the point is definitely not in the Mandelbrot set, calculate its
        // colour based on the escape value (i.e. how quickly we can determine
        // that it is definitely not in the set).
        if (escape_val < accuracy) {
          c = gradient[escape_val % gradient.length];
        }

        // Render the pixel
        pw.setColor(x + dx, y + dy, c);

      }
    }
  }

  private class Renderer extends Thread {

    // We record the properties of the canvas at the time an instance of this
    // class is created
    protected double width;
    protected double height;
    protected double centreX;
    protected double centreY;
    protected double scale;

    public Renderer(
        double width, double height,
        double centreX, double centreY,
        double scale)
    {
      this.width = width;
      this.height = height;
      this.centreX = centreX;
      this.centreY = centreY;
      this.scale = scale;
      // This means that the thread will not keep on running if the application
      // is terminated by the user (i.e. by clicking the close button).
      setDaemon(true);
    }

    @Override
    public void run () {

      // Create the image onto which we will render the visualisation
      WritableImage img = new WritableImage((int) width, (int) height);

      // We'll render the whole image
      Rectangle r = new Rectangle(width, height);

      // Compute the visualisation
      render(img, centreX, centreY, scale, r, accuracy);

      // Display the image
      displayImage(img);
    }

    // Now we want to make the image actually appear on the screen.
    // We can only update the GUI in the application thread, not in this thread.
    // So, what we do is is ask the application to run a given Runnable in the
    // application thread.
    protected void displayImage(WritableImage img) {
      Platform.runLater(
        new Runnable() {
          public void run () {
            MandelbrotCanvas c = MandelbrotCanvas.this;
            synchronized (c) {
              if (centreX == c.centreX && centreY == c.centreY && scale == c.pxScale) {
                // This draws the image we have computed on the canvas
                c.getGraphicsContext2D().drawImage(img, 0, 0);
              }
            }
          }
        }
      );
    }

  }

  /**
   * Create a Thread object that will compute the visualisation of the
   * Mandelbrot set for the current state of the canvas, and then display it.
   * 
   * This method is synchronised because we do not want any input events from
   * the user to change the state of the canvas while we are recording them for
   * the rendering thread.
   * 
   * @return The rendering Thread.
   */
  public synchronized Thread getRenderer() {
    return new MultiThreadRenderer(
      getWidth(),
      getHeight(),
      centreX,
      centreY,
      pxScale,
      num_threads
    );
  }

  /**
   * The constructor
   * @param num_threads
   */
  public MandelbrotCanvas(int num_threads) {
  
    this.num_threads = num_threads;

    // This allows the canvas to receive keyboard input events
    this.setFocusTraversable(true);

    // Set an event handler for when the mouse is clicked on the canvas
    this.setOnMouseClicked(
      // Here we are creating an anonymous class implementing the
      // EventHandler<MouseEvent> interface
      new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          // We are sychronising on the canvas object, to make sure that other
          // event handlers do not access its fields at the same time we do.
          synchronized (MandelbrotCanvas.this) {
            // Update the centre of the canvas
            centreX
              += ((e.getX() - (getWidth() / 2) + (getWidth() % 2)) * pxScale);
            centreY 
              -= ((e.getY() - (getHeight() / 2) + (getHeight() % 2)) * pxScale);
            System.out.println("centre: (" + centreX + ", " + centreY + ")");
          }

          // Get a rendering thread and start it.
          // We do not want to compute the visualisation here because it may
          // take some time and this code is run by the event handling thread.
          // If we block it with computation, the GUI will become unresponsive.
          getRenderer().start();
        }
      }
    );

    // Set an event handler for when keys are typed
    this.setOnKeyTyped(
      // Here we are creating an anonymous class implementing the
      // EventHandler<MouseEvent> interface
      new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
          // We are sychronising on the canvas object, to make sure that other
          // event handlers do not access its fields at the same time we do.
          synchronized (MandelbrotCanvas.this) {
            // If the key was "+", then zoom in
            if (e.getCharacter().equals("+")) {
              zoomIn();
            // If the key was "-", then xoom out
            } else if (e.getCharacter().equals("-")) {
              zoomOut();
            // If the key was "0", return to the initial zoom level
            } else if (e.getCharacter().equals("0")) {
              pxScale = INIT_ZOOM;
            // If it was any other key, just return immediately
            } else {
              return;
            }
          }
          // Now we have updated the state of the canvas (i.e. the zoom level),
          // start a renderer thread to update the GUI.
          getRenderer().start();
        }   
      }
    );

    // Set the width and height of the canvas
    this.setHeight(768.0);
    this.setWidth(1024.0);

    // Get a thread to render the visualisation and start it.
    // Again, we do not want to compute the visualisation here and block the
    // main application thread.
    getRenderer().start();

  }




















  /**
   * This class inherits from the Renderer class, so in particular it will
   * inherit the fields recording the centre point, zoom level, and width and
   * height of the canvas that are passed to new instances when they are
   * created.
   */
  private class MultiThreadRenderer extends Renderer {

    // The number of threads that we can use to compute the image in parallel
    private int num_threads;

    public MultiThreadRenderer (
        double width, double height,
        double centreX, double centreY,
        double scale,
        int num_threads)
    {
      super(width, height, centreX, centreY, scale);
      this.num_threads = num_threads;
    }

    /**
     * We create here another subclass of Thread.
     * Instances of this class have a reference to the image, and also a
     * Rectangle object specifying which part of the image they should render.
     */
    private class Worker extends Thread {

      // The image to render on
      private WritableImage img;

      // The part of the image to render
      private Rectangle rectangle;

      public Worker(Rectangle rectangle, WritableImage img) {
        this.rectangle = rectangle;
        this.img = img;
        this.setDaemon(true);
      }

      /**
       * All the worker thread should do is render the visualtion on the image
       * inside its own rectangle.
       */
      @Override public void run () {
        render(img, centreX, centreY, scale, rectangle, accuracy);
      }

    }

    /**
     * We're overriding the run method here, so this is the code that will
     * execute when we run the thread, not the code in the run method of the
     * superclass.
     */
    @Override
    public void run () {

      // Create the image on which to render the visualisation
      WritableImage img = new WritableImage((int) width, (int) height);

      /* 
       * Now create different worker threads, whose jobs it will be to render
       * the visualisation of different portions of the image in parallel.
       */
      List<Thread> workers = new ArrayList<Thread>();
      
      /**
       * We'll split the image up by width into as many rectangles as threads.
       */
      int worker_width = ((int) width) / num_threads;
      for (int i = 1; i <= num_threads; i++) {
        // Calculate the rectangle for the worker thread to render
        Rectangle r =
          new Rectangle(
            (i - 1) * worker_width,
            0,
            (i < num_threads) 
              ? worker_width : worker_width + ((int) width) % num_threads,
            height
          );
        // Create the worker thread, giving it a reference to the image onto
        // which it should render, and the area (rectangle) it should render.
        Thread worker = new Worker(r, img);
        // Add the thread to the list
        workers.add(worker);
        // Start the thread!
        worker.start();
      }

      // Now we wait for all the worker threads to finish rendering
      try {
        for (Thread worker : workers) {
          worker.join();
        }
      }
      catch (InterruptedException e) {
        System.err.println(e);
        e.printStackTrace();
      }

      // Display the image (displayImage method inherited)
      displayImage(img);
    }

  }

}