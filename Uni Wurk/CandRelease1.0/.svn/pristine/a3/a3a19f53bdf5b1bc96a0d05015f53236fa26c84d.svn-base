package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestNumStack {

  private NumStack num;

  @BeforeEach
  void setup() {
    num = new NumStack();
  }

  @Test
  void testEmptyStack() {
    // Test 1 checks the size of the stack by default is 0.
    assertEquals(num.size(), 0);
  }

  @Test
  void testIsEmpty() {
    // Test 2 checks the recently instantiated stack is empty.
    assertEquals(num.isEmpty(), true);
  }

  @Test
  void testEmptyPop() {
    // Test 3 checks if an exception is thrown when an empty numeric stack is popped.
    assertThrows(EmptyStackException.class, () -> num.pop(), "You cannot pop an empty stack.");
  }

  @Test
  void testOnePush() {
    // Test 4 checks if the size of stack after a single push.
    num.push(5);
    assertEquals(num.size(), 1);
  }

  @Test
  void pushThenPop() throws BadTypeException {
    // Test 5 checks what happens in the case of pushing then popping an empty numeric stack.
    num.push(5);
    assertEquals((int) num.pop().getNumber(), 5);
    assertEquals(num.size(), 0,
        "Pushing, then popping an empty stack should give the stack a size of 0.");
    assertThrows(EmptyStackException.class, () -> num.pop(), "You cannot pop an empty stack.");
  }

  @Test
  void pushTwice() throws BadTypeException {
    // Test 6 checks what happens in the case of pushing and popping twice then attempting to pop
    // again.
    num.push(8);
    num.push(16);
    assertEquals((int) num.pop().getNumber(), 16, "The method pop should return the value 16.");
    assertEquals((int) num.pop().getNumber(), 8, "The method pop should return the value 8.");
    assertEquals(num.size(), 0, "Pushing and popping twice should result to an empty stack.");
    assertThrows(EmptyStackException.class, () -> num.pop(), "You cannot pop an empty stack.");
  }
  
}