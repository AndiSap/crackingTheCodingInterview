package chapter1.ArraysAndStringsTest;

import org.junit.Assert;
import org.junit.Before;
import chapter1.ArraysAndStrings.UniqueString;
import org.junit.Test;
import testLogger.TestLogger;

public class UniqueStringTest {
    UniqueString instance;
    TestLogger logger = new TestLogger(this);

    @Before
    public void setUp() {
        instance = new UniqueString();
    }

    @Test
    public void testIsUniqueTrue() {
        logger.log("Testing isUnique true case");
        String word = "abcdefg";
        Assert.assertTrue(instance.isUnique(word));
    }

    @Test
    public void testIsUniqueFalse() {
        logger.log("Testing isUnique false case");
        String word = "abcdafg";
        Assert.assertFalse(instance.isUnique(word));
    }

    @Test
    public void testIsUniqueEdge() {
        logger.log("Testing isUnique edge case");
        String word = "";
        Assert.assertTrue(instance.isUnique(word));
    }

}
