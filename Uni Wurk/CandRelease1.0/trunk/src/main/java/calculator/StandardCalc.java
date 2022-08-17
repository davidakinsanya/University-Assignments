package calculator;

/**
 * Program purposed with evaluating standard notation string string expressions utilising the
 * shunting algorithm.
 * 
 * @author david
 */

public class StandardCalc implements Calculator {
  private StrStack str;
  private RevPolishCalc rev;
  private OpStack op;


  /**
   * This constructor initialises the standard class creating new StrStack, OpStack and
   * RevPolishCalc objects to implement the shunting algorithm.
   */
  public StandardCalc() {
    str = new StrStack();
    rev = new RevPolishCalc();
    op = new OpStack();
  }

  /**
   * This method is purposed with finding the solution to a given string expression with the help of
   * the StrStack, OpStack and RevPolishCalc objects.
   * 
   * @param expr the string expression to be evaluated.
   * @return the solution to the string expression as a float.
   * @throws BadTypeException if an entry object without a number assigned attempts to call the
   *         method.
   * @throws InvalidExpression if you attempt to evaluate an expression of the wrong notation in
   *         either RevPolishCalc or StandardCalc classes.
   */
  public float evaluate(String expr) throws BadTypeException, InvalidExpression {
    String sym = "+-*/";
    String[] exprArray = expr.split(" ");

    if (sym.contains(exprArray[exprArray.length - 1])) {
      throw new InvalidExpression();
    }
    Entry top;
    for (int i = 0; i < exprArray.length; i++) {
      String string = exprArray[i];

      if (string.equals(Symbol.PLUS.getSign())) {
        if (!op.isEmpty()) {
          // It is first checked if the stack of operators is empty.
          // If so, we grab the top of the stack and compare
          // precedence between its operator and the operator were dealing 
          // with in the if statement we do this for '+' and '-'.
          top = op.stack().top();
          actOnPres(top, Symbol.PLUS);
        } else {
          op.push(Symbol.PLUS);
        }
      } else if (string.equals(Symbol.MINUS.getSign())) {
        if (!op.isEmpty()) {
          top = op.stack().top();
          actOnPres(top, Symbol.MINUS);
        } else {
          op.push(Symbol.MINUS);
        }
      } else if (string.equals(Symbol.LEFT_BRACKET.getSign())) {
        op.push(Symbol.LEFT_BRACKET);

      } else if (string.equals(Symbol.RIGHT_BRACKET.getSign())) {
        Entry e;
        while ((e = op.pop()).getSymbol() != Symbol.LEFT_BRACKET) {
          str.push(e.getSymbol().getSign());
        }

      } else if (string.equals(Symbol.TIMES.getSign())) {
        op.push(Symbol.TIMES);

      } else if (string.equals(Symbol.DIVIDE.getSign())) {
        op.push(Symbol.DIVIDE);

      } else {
        str.push(string);
      }
    }

    while (!op.isEmpty()) {
      str.push(op.pop().getSymbol().getSign());
    }
    String newExpr = this.reverse(str.toString());
    return rev.evaluate(newExpr);
  }


  /**
   * This method is purposed with reversing a string so it falls into infix notation.
   * 
   * @param s String to be reversed
   * @return a string that can be evaluated as an infix expression
   */
  public String reverse(String s) {
    // We use reverse() in this way as the String Stack is LIFO
    // and conflicts with the way we approach reverse polish notation.
    String[] str = s.split(" ");
    int count = str.length - 1;
    String newStr = "";

    while (count >= 0) {
      if (count == 0) {
        newStr = newStr + str[count];
      } else {
        newStr = newStr + str[count] + " ";
      }
      count--;
    }
    return newStr;
  }

  /**
   * Method used to access the precedence between operators.
   * 
   * @param ch the operator to be accessed
   * @return the operators precedence
   */
  public int checkPres(String ch) {
    // We use checkPres() simply to assign precedence to important 
    // operators in a way resembling BIDMAS.
    switch (ch) {
      case "+":
      case "-":
        return 1;

      case "*":
      case "/":
        return 2;
      default:
        return -1;

    }
  }

  /**
   * Method for performing push() and pop() on different stacks depending on precedence.
   * 
   * @param e the entry object of the operator at the top of stack
   * @param s the symbol we want to compare to that of the top of the stack
   * @throws BadTypeException if an entry object without a number assigned attempts to call the
   *         method.
   */
  public void actOnPres(Entry e, Symbol s) throws BadTypeException {
    String n = e.getSymbol().getSign();
    if (this.checkPres(s.getSign()) >= this.checkPres(n)) {
      // if the precedence of the operator the program is currently dealing with
      // is higher that that of the top of the stack
      // we push it straight to the stack of operators.
      op.push(s);
    } else {
      // if otherwise, we push the operator at the top of the stack 
      // into the string stack and push the current operator
      // into the stack of operators in it's place.
      str.push(op.pop().getSymbol().getSign());
      op.push(s);
    }
  }
}