package calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;


/**
 * This class represents a stack of entry values inputed by the user.
 * 
 * @author david
 */
public class Stack {
  
  private int size;
  private List<Entry> entries;
  
  
  /**
   * This constructor initialises a stack object to store user input.
   */
  public Stack() {
    this.size = 0;
    entries = new ArrayList<Entry>();
  }
  
  
  /**
   * Retrieves the number of entries in the stack.
   * 
   * @return the number of entries within the stack
   */
  public int size() {
    return size;
  }
  
  
  /**
   * Adds an entry object to the top of the stack.
   * 
   * @param e the entry object to be pushed to the top of the stack
   */
  public void push(Entry e) {
    entries.add(e);
    size++;
  }
  
  
  /**
   * Removes and returns the top-most stack entry. 
   * 
   * 
   * @return the entry object popped from the stack
   */
  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Entry e = entries.get(size - 1);
    entries.remove(size - 1);
    size--;
    return e;
  }
  
  
  /**
   * Retrieves and retains the entry object at the top of the stack.
   * 
   * @return the top-most entry object in the stack
   */
  public Entry top() {
    if (this.size() == 0) {
      return null;
    }
    return entries.get(size - 1);
  }
  
}
