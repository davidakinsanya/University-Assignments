package calculator;


/**
 * This program serves as a collection of constants based on the symbols inputed into the calculator
 * program.
 * 
 * 
 * @author david
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID;

  private String symbol;


  /**
   * First constructor for the symbol class for valid symbols.
   * 
   * @param symbol the string representation of the symbol
   */
  private Symbol(String symbol) {
    this.symbol = symbol;
  }


  /**
   * Second constructor for the symbol class for invalid symbols.
   */
  private Symbol() {
    return;
  }
  
  
  /**
   * Extracting the string representation of a symbol.
   * 
   * @return the symbol represented by the enum variable
   * @throws BadTypeException if the function is applied to Symbol.INVALID
   */
  public String getSign() throws BadTypeException {
    if (symbol == null) {
      throw new BadTypeException();
    }
    return symbol;
  }
}
