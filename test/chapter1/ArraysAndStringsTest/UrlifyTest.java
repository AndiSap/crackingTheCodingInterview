package chapter1.ArraysAndStringsTest;

import chapter1.ArraysAndStrings.Urlify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testLogger.TestLogger;

import java.util.Arrays;

public class UrlifyTest {
    Urlify instance;
    TestLogger logger = new TestLogger(this);

    @Before
    public void setUp() {
        instance = new Urlify();
    }

    @Test
    public void testUrlifyWordTrue() {
        logger.log("Testing urlify true case");
        char[] word = "Mr John Smith    ".toCharArray();
        char[] expectedResult = "Mr%20John%20Smith".toCharArray();
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(instance.urlifyWord(word, 13)));
    }

    @Test
    public void testUrlifyWordFalse() {
        logger.log("Testing urlify false case");
        char[] word = "Mr JohnSmith  ".toCharArray();
        char[] expectedResult = "Mr%20John%20Smith".toCharArray();
        Assert.assertNotEquals(Arrays.toString(expectedResult), Arrays.toString(instance.urlifyWord(word, 12)));
    }

    @Test
    public void testUrlifyWordEdge() {
        logger.log("Testing urlify edge case");
        char[] word = "   ".toCharArray();
        char[] expectedResult = "%20".toCharArray();
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(instance.urlifyWord(word, 1)));
    }

    @Test
    public void testUrlifyWordTrueOptimized() {
        logger.log("Testing urlify true case optimized");
        char[] word = "Mr John Smith    ".toCharArray();
        char[] expectedResult = "Mr%20John%20Smith".toCharArray();
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(instance.optimalUrlify(word, 13)));
    }

    @Test
    public void testUrlifyWordFalseOptimized() {
        logger.log("Testing urlify false case optimized");
        char[] word = "Mr JohnSmith  ".toCharArray();
        char[] expectedResult = "Mr%20John%20Smith".toCharArray();
        Assert.assertNotEquals(Arrays.toString(expectedResult), Arrays.toString(instance.optimalUrlify(word, 12)));
    }

    @Test
    public void testUrlifyWordEdgeOptimized() {
        logger.log("Testing urlify edge case optimized");
        char[] word = "   ".toCharArray();
        char[] expectedResult = "%20".toCharArray();
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(instance.optimalUrlify(word, 1)));
    }

}
