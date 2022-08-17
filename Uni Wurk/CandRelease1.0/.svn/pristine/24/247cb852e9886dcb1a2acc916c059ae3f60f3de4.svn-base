package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {

  private OpStack op;

  @BeforeEach
  void setup() {
    op = new OpStack();
  }

  @Test
  void testEmptyStack() {
    // Test 1 checks the default states of an empty operator stack.
    assertEquals(op.isEmpty(), true);
    assertEquals(op.size(), 0);
  }
  
  @Test 
  void pushOneSymbol() throws BadTypeException {
    // Test 2 checks output of a single push and pop function call.
    op.push(Symbol.PLUS);
    assertEquals(op.size(), 1);
    assertEquals(op.pop().getSymbol(), Symbol.PLUS);
    assertThrows(EmptyStackException.class, () -> op.pop(), "You cannot pop an empty stack.");
  }
  
  @Test 
  void pushTwoSymbol() throws BadTypeException {
    // Test 3 checks output of a two push and pop function calls.
    op.push(Symbol.PLUS);
    op.push(Symbol.MINUS);
    assertEquals(op.pop().getSymbol(), Symbol.MINUS);
    assertEquals(op.pop().getSymbol(), Symbol.PLUS);
    assertThrows(EmptyStackException.class, () -> op.pop(), "You cannot pop an empty stack.");
  }
}