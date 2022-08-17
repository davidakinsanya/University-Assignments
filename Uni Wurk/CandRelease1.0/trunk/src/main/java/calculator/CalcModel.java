package calculator;

/**
 * Program to show the values of the expression in the calculator.
 * 
 * @author david
 */
public class CalcModel {
  private Calculator revPolish;
  private Calculator standard;
  
  
  /**
   * Constructor purposed with instantiating the two Calculator interfaces.
   */
  public CalcModel() {
    revPolish = new RevPolishCalc();
    standard = new StandardCalc();
  }
  
  
  /**
   * Method for calculating the calculator expression depending on if its infix or postfix notation.
   * 
   * @param expr the string expression to be evaluated.
   * @param infix boolean expression pertaining to expression notation
   * @return the solution to the string expression as a float.
   *@throws BadTypeException if an entry object without a number assigned attempts to call the
   *         method.
   * @throws InvalidExpression if you attempt to evaluate an expression of the wrong notation in
   *         either RevPolishCalc or StandardCalc classes.
   */
  public float evaluate(String expr, boolean infix) throws BadTypeException, InvalidExpression {
    if (infix) {
      return revPolish.evaluate(expr);
    }
    return standard.evaluate(expr);
    
  }
}