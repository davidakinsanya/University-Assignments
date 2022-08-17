package calculator;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Program tasked with creating a view for the calculator and overseeing its functionality.
 * 
 * @author david
 */
public class CalcController extends Application {

  @FXML
  private RadioButton standard = new RadioButton();
  @FXML
  private RadioButton revPolish = new RadioButton();
  @FXML
  private TextField text = new TextField();


  private CalcModel model;
  private boolean infix;
  private Stage stage;
  private AnchorPane layout;


  /**
   * Constructor solely purposed with instantiating the model object.
   */
  public CalcController() {
    model = new CalcModel();
  }


  /**
   * Method for checking which notation the user wants to use.
   * 
   * @throws InvalidExpression if you attempt to evaluate an expression of the wrong notation in
   *         either RevPolishCalc or StandardCalc classes.
   */
  @FXML
  public boolean radioEvent() throws InvalidExpression {
    if (standard.isSelected()) {
      return true;
    } else if (revPolish.isSelected()) {
      return false;
    } else {
      text.setText("Select a notation pls...");
      throw new InvalidExpression();
    }
  }


  /**
   * Method for retrieving the expression from the GUI and displaying the solution.
   * 
   * @throws BadTypeException if an entry object without a number assigned attempts to call the
   *         method.
   * @throws InvalidExpression if you attempt to evaluate an expression of the wrong notation in
   *         either RevPolishCalc or StandardCalc classes.
   */

  public void calculate(ActionEvent e) throws InvalidExpression, BadTypeException {
    if (text.getText().length() == 0) {
      standard.setSelected(false);
      revPolish.setSelected(false);
      return;
    }
    
    infix = radioEvent();
    
    if (infix) {
      String temp = 
          text.getText().replaceAll("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)", " ");
      temp = temp.replace(" . ", ".");
      String expr = Float.toString(model.evaluate(temp, infix));
      text.setText(expr);
      standard.setSelected(false);
      revPolish.setSelected(false);
      return;
    }
    
    String temp = text.getText();
    String expr = Float.toString(model.evaluate(temp, infix));
    text.setText(expr);
    standard.setSelected(false);
    revPolish.setSelected(false);
  }


  /**
   * Method for configuring the elements of the GUI.
   * 
   * @param stage the platform to host the GUI elements
   */
  @Override
  public void start(Stage stage) throws Exception {
    this.stage = stage;
    this.stage.setTitle("A* Caclulator");
    showMainView();
  }


  /**
   * Method for rendering the fxml file.
   * 
   * @throws IOException thrown when the fxml file can't be found by the program.
   */
  public void showMainView() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("calculatorView.fxml"));
    this.layout = loader.load();
    Scene scene = new Scene(layout);
    stage.setScene(scene);
    stage.show();
  }


  /**
   * Main method launches the GUI for the users.
   */
  public static void main(String[] args) {
    launch(args);
  }
}