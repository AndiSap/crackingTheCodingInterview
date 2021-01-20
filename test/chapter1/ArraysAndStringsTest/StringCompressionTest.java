package chapter1.ArraysAndStringsTest;

import chapter1.ArraysAndStrings.StringCompression;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testLogger.TestLogger;

public class StringCompressionTest {
    StringCompression instance;
    TestLogger logger = new TestLogger(this);
    String word = "aabcccccaaa";

    @Before
    public void setUp() {
        instance = new StringCompression();
    }

    @Test
    public void testCompressTrue() {
        logger.log("Testing string compression true case");
        String expected = "a2b1c5a3";
        Assert.assertEquals(expected, instance.compress(word));
    }

    @Test
    public void testCompressFalse() {
        logger.log("Testing string compression false case");
        String longString = "abcd";
        Assert.assertEquals(longString, instance.compress(longString));
    }

    @Test
    public void testCompressEdge() {
        logger.log("Testing string compression edge case");
        String word = "a";
        Assert.assertEquals(word, instance.compress(word));
    }

}
