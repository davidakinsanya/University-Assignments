package calculator;

/**
 * This class represents a stack of numeric entry values inputed by the user.
 * 
 * @author david
 */
public class NumStack {

  private Stack numStack;


  /**
   * This constructor initialises a stack object to store numeric input.
   */
  public NumStack() {
    numStack = new Stack();
  }


  /**
  * Retrieves the number of entries in the stack.
  *
  * @return the number of entries within the stack
  */
  public int size() {
    return numStack.size();
  }

  
  /**
   * Checks whether or not the numeric stack is empty.
   * 
   * @return the boolean state of whether or not the numeric stack is empty
   */
  public boolean isEmpty() {
    return numStack.size() == 0;
  }

  
  /**
   * Adds an entry object to the top of the numeric stack.
   * 
   * @param i the floating integer to be pushed to the top of the numeric stack.
   */
  public void push(float i) {
    numStack.push(new Entry(i));
  }


  
  /**
   * Removes and returns the top-most stack entry. 
   * 
   * 
   * @return the entry object popped from the stack
   */
  public Entry pop() {
    return numStack.pop();
  }
}