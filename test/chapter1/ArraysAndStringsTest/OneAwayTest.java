package chapter1.ArraysAndStringsTest;

import chapter1.ArraysAndStrings.OneAway;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testLogger.TestLogger;

/**
 * @todo: Refactor unit tests so different version of method can be used without duplicated tests
 */
public class OneAwayTest {
    OneAway instance;
    TestLogger logger = new TestLogger(this);
    String base = "pale";

    @Before
    public void setUp() {
        instance = new OneAway();
    }

    @Test
    public void testCheckTrue() {
        logger.log("Testing one away true case");
        String word1 = "pales";
        String word2 = "ple";
        String word3 = "bale";
        Assert.assertTrue(instance.check(base, word1));
        Assert.assertTrue(instance.check(base, word2));
        Assert.assertTrue(instance.check(base, word3));
    }

    @Test
    public void testCheckFalse() {
        logger.log("Testing one away false case");
        String word1 = "bake";
        Assert.assertFalse(instance.check(base, word1));
    }

    @Test
    public void testCheckEdge() {
        logger.log("Testing one away edge case");
        String word = "";
        Assert.assertTrue(instance.check(" ", word));
    }

    @Test
    public void testCheckTrueHash() {
        logger.log("Testing one away true case using hashmap");
        String word1 = "pales";
        String word2 = "ple";
        String word3 = "bale";
        Assert.assertTrue(instance.checkWithHash(base, word1));
        Assert.assertTrue(instance.checkWithHash(base, word2));
        Assert.assertTrue(instance.checkWithHash(base, word3));
    }

    @Test
    public void testCheckFalseHash() {
        logger.log("Testing one away false case using hashmap");
        String word1 = "bake";
        Assert.assertFalse(instance.checkWithHash(base, word1));
    }

    @Test
    public void testCheckEdgeHash() {
        logger.log("Testing one away edge case using hashmap");
        String word = "";
        Assert.assertTrue(instance.checkWithHash("", word));
    }

    @Test
    public void testCheckTrueCompressed() {
        logger.log("Testing one away true case using compressed version");
        String word1 = "pales";
        String word2 = "ple";
        String word3 = "bale";
        Assert.assertTrue(instance.oneEditAwayCompressed(base, word1));
        Assert.assertTrue(instance.oneEditAwayCompressed(base, word2));
        Assert.assertTrue(instance.oneEditAwayCompressed(base, word3));
    }

    @Test
    public void testCheckFalseCompressed() {
        logger.log("Testing one away false case using compressed version");
        String word1 = "bake";
        Assert.assertFalse(instance.oneEditAwayCompressed(base, word1));
    }

    @Test
    public void testCheckEdgeCompressed() {
        logger.log("Testing one away edge case using compressed version");
        String word = "";
        Assert.assertTrue(instance.oneEditAwayCompressed("", word));
    }

}
