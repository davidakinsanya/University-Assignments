package calculator;

/**
 * Program purposed with evaluating reverse polish string expressions.
 * 
 * 
 * @author david
 *
 */
public class RevPolishCalc implements Calculator {

  private NumStack values;

  /**
   * This constructor initialises the reverse polish class creating a new NumStack object to push
   * and pop portions of the expression.
   */
  
  public RevPolishCalc() {
    values = new NumStack();
  }

  /**
   * This method is purposed with finding the solution to a given string expression with the help of
   * the NumStack object.
   * 
   * @param expr the string expression to be evaluated.
   * @return the solution to the string expression as a float.
   * @throws BadTypeException if an entry object without a number assigned attempts to call the
   *         method.
   * @throws InvalidExpression if you attempt to evaluate an expression of the wrong notation in
   *         either RevPolishCalc or StandardCalc classes.
   */
  public float evaluate(String expr) throws BadTypeException, InvalidExpression {
    float num1;
    float num2;
    String[] exprArray = expr.split(" ");
    // to evaluate the expression it is first broken down into an array
    // so its individual elements can be evaluated.
    String sym = "+-*/";

    if (!sym.contains(exprArray[exprArray.length - 1])) {
      throw new InvalidExpression();
    }

    for (int i = 0; i < exprArray.length; i++) {
      String string = exprArray[i];

      if (string.equals(Symbol.PLUS.getSign())) {
        // If the method encounters a '+' operator, it pops the stack twice
        // adds the numbers and pushes the result back to the stack.
        values.push(values.pop().getNumber() + values.pop().getNumber());

      } else if (string.equals(Symbol.TIMES.getSign())) {
        // If the method encounters a '*' operator, it pops the stack twice
        // multiplies the numbers and pushes the result back to the stack.
        values.push(values.pop().getNumber() * values.pop().getNumber());

      } else if (string.equals(Symbol.MINUS.getSign())) {
        // If the method encounters a '-' operator, it pops the stack twice
        // into variables, subtracts the numbers and in proper order pushes the result back to the
        // stack.
        num1 = values.pop().getNumber();
        num2 = values.pop().getNumber();
        values.push(num2 - num1);

      } else if (string.equals(Symbol.DIVIDE.getSign())) {
        // If the method encounters a '/' operator, it pops the stack twice
        // into variables, divides the numbers in proper order and pushes the result back to the
        // stack.
        num1 = values.pop().getNumber();
        num2 = values.pop().getNumber();
        values.push(num2 / num1);
      } else {
        // If a number is detected, it is pushed straight to the stack.
        values.push(Float.parseFloat(exprArray[i]));
      }
    }

    float solution = values.pop().getNumber();
    return solution;
  }
}
