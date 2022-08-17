package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {
  
  public StrStack str;
  
  @BeforeEach
  void setup() {
    str = new StrStack();
  }
  
  @Test
  void testEmptyStack() {
    // Test 1 checks the default states of an empty string stack.
    assertEquals(str.isEmpty(), true);
    assertEquals(str.size(), 0);
  }
  
  @Test 
  void pushOneSymbol() throws BadTypeException {
    // Test 2 checks output of a single push and pop function call.
    str.push("8+4");
    assertEquals(str.size(), 1);
    assertEquals(str.pop().getString(), "8+4");
    assertThrows(EmptyStackException.class, () -> str.pop(), "You cannot pop an empty stack.");
  }
  
  @Test 
  void pushTwoSymbol() throws BadTypeException {
    // Test 3 checks output of a two push and pop function calls.
    str.push("8+4");
    str.push("80+40");
    assertEquals(str.pop().getString(), "80+40");
    assertEquals(str.pop().getString(), "8+4");
    assertThrows(EmptyStackException.class, () -> str.pop(), "You cannot pop an empty stack.");
  }
}