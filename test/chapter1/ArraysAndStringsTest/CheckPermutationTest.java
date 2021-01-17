package chapter1.ArraysAndStringsTest;

import chapter1.ArraysAndStrings.CheckPermutation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testLogger.TestLogger;

public class CheckPermutationTest {
    CheckPermutation instance;
    TestLogger logger = new TestLogger(this);

    @Before
    public void setUp() {
        instance = new CheckPermutation();
    }

    @Test
    public void testCheckPermutationTrue() {
        logger.log("Testing check true case");
        String word1 = "testop1";
        String word2 = new StringBuilder(word1).reverse().toString();
        Assert.assertTrue(instance.check(word1, word2));
    }

    @Test
    public void testCheckPermutationFalse() {
        logger.log("Testing check false case");
        String word1 = "testop1";
        StringBuilder word2Raw = new StringBuilder(word1).reverse();
        String word2 = word2Raw.append("abc").toString();
        Assert.assertFalse(instance.check(word1, word2));
    }

    @Test
    public void testCheckPermutationEdge() {
        logger.log("Testing check edge case");
        String word1 = "";
        String word2 = "a";
        Assert.assertFalse(instance.check(word1, word2));
    }

    @Test
    public void testCheckPermutationTrueOptimized() {
        logger.log("Testing check true case optimized");
        String word1 = "testop1";
        String word2 = new StringBuilder(word1).reverse().toString();
        Assert.assertTrue(instance.optimizedCheck(word1, word2));
    }

    @Test
    public void testCheckPermutationFalseOptimized() {
        logger.log("Testing check false case optimized");
        String word1 = "testop1";
        StringBuilder word2Raw = new StringBuilder(word1).reverse();
        String word2 = word2Raw.append("abc").toString();
        Assert.assertFalse(instance.optimizedCheck(word1, word2));
    }

    @Test
    public void testCheckPermutationEdgeOptimized() {
        logger.log("Testing check edge case optimized");
        String word1 = "";
        String word2 = "a";
        Assert.assertFalse(instance.optimizedCheck(word1, word2));
    }

}
