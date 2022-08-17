package calculator;

/**
 * This class represents a stack of operator entry values inputed by the user.
 * 
 * @author david
 */
public class OpStack {

  public Stack opStack;

  /**
   * This constructor initialises a stack object to store operator.
   */
  public OpStack() {
    opStack = new Stack();
  }
  
  
  /**
   * Checks whether or not the numeric stack is empty.
   * 
   * @return the boolean state of whether or not the operator stack is empty
   */
  public boolean isEmpty() {
    return opStack.size() == 0;
  }
  
  
  
  /**
   * Retrieves the number of entries in the operator stack.
   *
   * @return the number of operators within the stack
   */
  public int size() {
    return opStack.size();
  }
  
  /**
   * Retrieves the opStack variable.
   *
   * @return the opStack variable used in the class.
   */
  public Stack stack() {
    return opStack;
  }
  
  
  /**
   * Adds an entry object to the top of the operator stack.
   * 
   * @param s the symbol to be pushed to the top of the operator stack.
   */
  public void push(Symbol s) {
    opStack.push(new Entry(s));
  }
  
  
  /**
   * Removes and returns the top-most stack entry. 
   * 
   * 
   * @return the operator entry object popped from the stack
   */
  public Entry pop() {
    return opStack.pop();
  }
}
