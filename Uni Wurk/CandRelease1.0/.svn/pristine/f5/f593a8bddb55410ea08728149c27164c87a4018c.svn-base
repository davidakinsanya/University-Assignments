package calculator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TestType {

  @Test
  void testForInclusion() {
    // Test 1 checks every enum variable is included and no duplicates exist.

    Set<String> a = new HashSet<String>();
    int j = 0;
    for (var i : Type.values()) {
      a.add(i.toString());
      j++;
    }
    assertTrue(a.size() == j);
  }
}


