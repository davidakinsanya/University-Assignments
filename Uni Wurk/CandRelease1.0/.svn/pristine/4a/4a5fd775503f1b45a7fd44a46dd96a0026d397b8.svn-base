package calculator;

/**
 * This class represents a stack of string entry values inputed by the user.
 * 
 * @author david
 */
public class StrStack {
  
  public Stack strStack;
  
  
  /**
   * This constructor initialises a stack object to store strings.
   */
  public StrStack() {
    strStack = new Stack();
  }
  
  
  /**
   * Checks whether or not the numeric stack is empty.
   * 
   * @return the boolean state of whether or not the string stack is empty
   */
  public boolean isEmpty() {
    return strStack.size() == 0;
  }
  
  
  /**
   * Retrieves the number of entries in the operator stack.
   *
   * @return the number of strings within the stack
   */
  public int size() {
    return strStack.size();
  }
  
  
  /**
   * Adds an entry object to the top of the operator stack.
   * 
   * @param s the symbol to be pushed to the top of the string stack.
   */
  public void push(String s) {
    strStack.push(new Entry(s));
  }
  
  
  /**
   * Removes and returns the top-most stack entry. 
   * 
   * 
   * @return the string entry object popped from the stack
   */
  public Entry pop() {
    return strStack.pop();
  }
  
  
  /**
   * Converts strStack object to a string.
   * 
   * @return the string representation of the strStack object.
   */
  public String toString() {
    String str = ""; 
    for (int j = strStack.size(); j > 0; j--) {
      if (j == strStack.size() - 1) {
        try {
          str = str + strStack.pop().getString();
        } catch (BadTypeException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      } else {
        try {
          str = str + strStack.pop().getString() + " ";
        } catch (BadTypeException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    return str; 
  }
}
