package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEntry {
  private Entry num;
  private Entry sym;
  private Entry str;

  @BeforeEach
  void createEntry() {
    num = new Entry(8);
    sym = new Entry(Symbol.PLUS);
    str = new Entry("8+4");
  }

  @Test
  void testNumber() throws BadTypeException {
    // Test 1 checks the number stored in the object is 8.
    assertEquals(num.getNumber(), 8);
  }

  @Test
  void testSign() throws BadTypeException {
    // Test 2 checks the symbol enum variable stored is Symbol.PLUS and has a '+' stored inside as
    // well.
    assertEquals(sym.getSymbol(), Symbol.PLUS);
    assertEquals(sym.getSymbol().getSign(), "+");
  }

  @Test
  void testString() throws BadTypeException {
    // Test 3 checks the string inside the object is "8+4".
    assertEquals(str.getString(), "8+4");
  }

  @Test
  void testEquals() {
    // Test 4 check for equality between entry objects.
    Entry n2 = new Entry(8);
    Entry s2 = new Entry(Symbol.PLUS);
    Entry str2 = new Entry("8+4");

    assertTrue(num.equals(n2));
    assertTrue(sym.equals(s2));
    assertTrue(str.equals(str2));

  }

  @Test
  void testNotEquals() {
    // Test 5 check for inequality between entry objects.
    Entry n2 = new Entry(8);
    Entry s2 = new Entry(Symbol.PLUS);
    Entry str2 = new Entry("8+4");

    assertFalse(num.equals(s2));
    assertFalse(s2.equals(str2));
    assertFalse(str2.equals(n2));
  }

  @Test
  void testBadType() {
    // Test 6 checks for numerous exception throws for bad types.
    assertThrows(BadTypeException.class, () -> sym.getString(),
        "You cannot get string from symbol type.");
    assertThrows(BadTypeException.class, () -> sym.getNumber(),
        "You cannot retrieve a float from a symbol type.");
    assertThrows(BadTypeException.class, () -> num.getString(),
        "You cannot retrieve a string from a float type.");
    assertThrows(BadTypeException.class, () -> str.getNumber(),
        "You cannot retrieve a float from a string type.");
    assertThrows(BadTypeException.class, () -> str.getSymbol(),
        "You cannot retrieve a symbol from a string type.");
  }
}
