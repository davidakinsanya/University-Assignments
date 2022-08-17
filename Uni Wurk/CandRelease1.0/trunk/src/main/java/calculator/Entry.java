package calculator;

import java.util.Objects;

/**
 * This program captures the values stored in a stack.
 * 
 * @author david
 */
public class Entry {

  private float number;
  private Symbol other;
  private String str;
  private Type type;


  /**
   * Constructor accepting an entry number from the user.
   * 
   * @param value the number inputed by the user
   */
  public Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }


  /**
   * Constructor accepting an arithmetic symbol from the user.
   * 
   * @param which the symbol inputed by the user
   */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }


  /**
   * Constructor accepting a string representation of an arithmetic expression from the user.
   * 
   * @param str the string inputed by the user
   */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }


  /**
   * Retrieves the number inputed by the user.
   * 
   * @return the number inputed by the user
   * @throws BadTypeException if an entry object without a number assigned attempts to
   *         call the method
   */
  public float getNumber() throws BadTypeException {
    if (Float.isNaN(number)) {
      throw new BadTypeException();
    }
    return number;
  }


  /**
   * Retrieves the symbol inputed by the user.
   * 
   * @return the symbol enum variable attached to the data inputed by the user
   * @throws BadTypeException if an entry object without a symbol assigned attempts to
   *         call the method
   */
  public Symbol getSymbol() throws BadTypeException {
    if (other == null) {
      throw new BadTypeException();
    }
    return other;
  }


  /**
   * Retrieves the arithmetic expression of the calculation the user wants to perform.
   * 
   * @return the string expression inputed by the user
   * @throws BadTypeException if an entry object without a string assigned attempts to
   *         call the method
   */
  public String getString() throws BadTypeException {
    if (str == null) {
      throw new BadTypeException();
    }
    return str;
  }


  /**
   * This method retrieves the type of data inputed by the user.
   * 
   * @return Returns the type enum variable attached to the data inputed by the user
   * @throws BadTypeException if an entry object without a type assigned attempts to
   *         call the method
   */
  public Type getType() throws BadTypeException {
    return type;
  }


  /**
   * Method for generating a hash code for entry objects with the taking a string and a type enum.
   */
  @Override
  public int hashCode() {
    return Objects.hash(str, type);
  }


  /**
   * This method checks for equality between two objects.
   * 
   * @return a boolean based on if the two objects are equal
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Entry)) {
      return false;
    }
    Entry other = (Entry) obj;
    return Objects.equals(str, other.str) && type == other.type;
  }
}