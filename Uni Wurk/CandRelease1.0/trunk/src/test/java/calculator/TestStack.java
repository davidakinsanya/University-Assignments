package calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {
  private Stack stack;

  @BeforeEach
  void createStack() {
    stack = new Stack();
  }


  @Test
  void testSize() {
    // Test 1 checks the size of the stack by default is 0.
    assertEquals(stack.size(), 0, "A Stack with no entries must have a size of 0.");
  }


  @Test
  void testPush() {
    // Test 2 checks the size of the stack goes up by 1 after calling push().
    stack.push(new Entry(8));
    assertEquals(stack.size(), 1, "A Stack with one entry must have a size of 1.");
  }


  @Test
  void testEmptyPop() {
    // Test 3 checks if an exception is thrown when an empty stack is popped.
    assertThrows(EmptyStackException.class, () -> stack.pop(), "You cannot pop an empty stack.");
  }


  @Test
  void pushThenPop() throws BadTypeException {
    // Test 4 checks what happens in the case of pushing then twice popping an empty stack.
    stack.push(new Entry(8));
    assertEquals((int) stack.pop().getNumber(), 8, "The method pop should return the value 8.");
    assertEquals(stack.size(), 0,
        "Pushing, then popping an empty stack should give the stack a size of 0.");
    assertThrows(EmptyStackException.class, () -> stack.pop(), "You cannot pop an empty stack.");
  }

  
  @Test
  void pushTwice() throws BadTypeException {
    // Test 5 checks what happens in the case of pushing and popping twice then attempting to pop
    // again.
    stack.push(new Entry(8));
    stack.push(new Entry(16));
    assertEquals((int) stack.pop().getNumber(), 16, "The method pop should return the value 16.");
    assertEquals((int) stack.pop().getNumber(), 8, "The method pop should return the value 8.");
    assertEquals(stack.size(), 0, "Pushing and popping twice should result to an empty stack.");
    assertThrows(EmptyStackException.class, () -> stack.pop(), "You cannot pop an empty stack.");
  }


  @Test
  void testTop() throws BadTypeException {
    // Test 6 checks the top most entry object when pushing to the stack once.
    stack.push(new Entry(8));
    assertEquals((int) stack.top().getNumber(), 8,
        "The top most stack entry should have the integer 8.");
  }


  @Test
  void pushTwiceTop() throws BadTypeException {
    // Test 7 checks the top most entry object when pushing to the stack twice.
    stack.push(new Entry(8));
    stack.push(new Entry(16));
    assertEquals((int) stack.top().getNumber(), 16,
        "The top most stack entry should have the integer 16.");
  }
}