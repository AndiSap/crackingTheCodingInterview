package chapter1.ArraysAndStringsTest;

import chapter1.ArraysAndStrings.PalindromePermutation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testLogger.TestLogger;

public class PalindromePermutationTest {
    PalindromePermutation instance;
    TestLogger logger = new TestLogger(this);

    @Before
    public void setUp() {
        instance = new PalindromePermutation();
    }

    @Test
    public void testIsPalindromePermTrue() {
        logger.log("Testing palidrome permutation true case");
        String word = "Tact Coa";
        Assert.assertTrue(instance.isPalindromePerm(word));
    }

    @Test
    public void testIsPalindromePermFalse() {
        logger.log("Testing palidrome permutation false case");
        String word = "Tac Coa";
        Assert.assertFalse(instance.isPalindromePerm(word));
    }

    @Test
    public void testIsPalindromePermEdge() {
        logger.log("Testing palidrome permutation edge case");
        String word = "";
        Assert.assertTrue(instance.isPalindromePerm(word));
    }

}
