package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {

  private StandardCalc calc;

  @BeforeEach
  void setup() {
    calc = new StandardCalc();
  }
  
  @Test 
  void testReverse() {
    // Test 0 
    // A simple test to check the functionality of my helper function reverse 
    // In its action to reverse a string into infix.
    assertEquals(calc.reverse("+ 1 1"), "1 1 +");
  }
 
  @Test 
  void testCheckPres() {
    // Test 0 
    // A simple test to check the functionality of my helper function reverse 
    // In its action to check the precedence of operators.
    assertEquals(calc.checkPres("+"), 1);
    assertEquals(calc.checkPres("/"), 2);
    assertEquals(calc.checkPres(">"), -1);
  }
  
  
  @Test
  void simpleEvaluation() throws BadTypeException, InvalidExpression {
    // First test gets the evaluate method to come up with the solution
    // to a simple arithmetic problem in standard notation.
    // using the shunting algorithm
    
    assertEquals(calc.evaluate("1 + 1"), 2);
  }

  @Test
  void lessSimpleEvaluation() throws BadTypeException, InvalidExpression {
    // Second test gets the evaluate method to come up with the solution
    // to a less simple arithmetic problem in standard notation.
    assertEquals(calc.evaluate("( 3 + 4 ) * 5"), 35);
  }
  

  
  @Test
  void moreComplexEvaluation() throws BadTypeException, InvalidExpression {
    // Third test gets the evaluate method to come up with the solution
    // to a more complicated arithmetic problem in reverse polish notation.
    // 6*(4+5) - 25/(2+3)
    assertEquals(calc.evaluate("6 * ( 4 + 5 ) - 25 / ( 2 + 3 )"), 49);
  }
  
  
  @Test
  void negativeNumberEvaluation() throws BadTypeException, InvalidExpression {
    // Fourth test gets the evaluate method to come up with the solution
    // to an expression which evaluates to a negative value in s notation.
    assertEquals(calc.evaluate("( 2 + 2 ) - 7"), -3);
  }
  
  
  @Test
  void largeNumbersEvaluation() throws BadTypeException, InvalidExpression {
    // Fifth test gets the evaluate method to come up with the solution
    // to a arithmetic problem with large numbers and nested operations
    // in reverse polish notation. (590) / (20 + (200-130))
    assertEquals(calc.evaluate("( 590 ) / ( 20 + ( 200 - 130 ) )"), 6.55555534362793);
  }
  
  @Test
  void testInvalidExpression() throws BadTypeException, InvalidExpression {
    // Last test examines the evaluate method when faced with a post fix notation expression.
    
    assertThrows(InvalidExpression.class, () -> calc.evaluate("3 4 + 5 *"),
        "You cannot enter a postfix notation expression.");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("6 4 5 + * 25 2 3 + / -"),
        "You cannot enter a postfix notation expression.");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("1 1 +"),
        "You cannot enter a postfix notation expression.");
  } 
}
  