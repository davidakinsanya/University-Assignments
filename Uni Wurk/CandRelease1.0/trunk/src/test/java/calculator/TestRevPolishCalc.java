package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  
  private RevPolishCalc calc;
  
  @BeforeEach
  void setup() {
    calc = new RevPolishCalc();
  }
  
  @Test
  void simpleEvaluation() throws BadTypeException {
    // First test gets the evaluate method to come up with the solution
    // to a simple arithmetic problem in reverse polish notation.
    assertEquals(calc.evaluate("11+"), 2);
  }
  
  @Test
  void lessSimpleEvaluation() throws BadTypeException {
    // Second test gets the evaluate method to come up with the solution
    // to a less simple arithmetic problem in reverse polish notation.
    assertEquals(calc.evaluate("34+5*"), 35);
  }

 @Test
  void moreComplexEvaluation() throws BadTypeException {
    // Third test gets the evaluate method to come up with the solution
    // to a more complicated arithmetic problem in reverse polish notation.
    assertEquals(calc.evaluate("6 4 5 + * 25 2 3 + / -"), 49);
  }

@Test
  void negativeNumberEvaluation() throws BadTypeException {
    // Fourth test gets the evaluate method to come up with the solution
    // to an expression which evaluates to a negative value in reverse polish notation.
    assertEquals(calc.evaluate("2 2 + 7 - "), -3);
  } 

@Test
  void largeNumbersEvaluation() throws BadTypeException {
    // Fifth test gets the evaluate method to come up with the solution
    // to a arithmetic problem with large numbers and nested operations
    // in reverse polish notation. (590) / (20 + (200-130))
    assertEquals(calc.evaluate("590 20 200 130 - + /"), 6.55555534362793);
  } 

 @Test
  void testInvalidExpression() throws BadTypeException, InvalidExpression {
    // Last test examines the evaluate method when faced with a standard notation expression.
    //assertEquals(calc.evaluate("1+2"), 3);
    assertThrows(InvalidExpression.class, () -> calc.evaluate("1+2"),
        "You cannot enter a standard notation expression.");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("10+28"),
        "You cannot enter a standard notation expression.");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("(80+20)*6"),
        "You cannot enter a standard notation expression.");
  } 
}
