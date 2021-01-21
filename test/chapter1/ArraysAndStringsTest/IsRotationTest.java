package chapter1.ArraysAndStringsTest;

import chapter1.ArraysAndStrings.IsRotation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testLogger.TestLogger;

public class IsRotationTest {
    IsRotation instance;
    TestLogger logger = new TestLogger(this);

    @Before
    public void setUp() {
        instance = new IsRotation();
    }

    @Test
    public void testIsSubStringTrue() {
        logger.log("Testing is substring true case");
        String word = "waterbottle";
        String substring = "erbott";
        Assert.assertTrue(instance.isSubstring(word, substring));
    }

    @Test
    public void testIsSubStringFalse() {
        logger.log("Testing is substring false case");
        String word = "waterbottle";
        String substring = "erobtt";
        Assert.assertFalse(instance.isSubstring(word, substring));
    }

    @Test
    public void testIsRotationTrue() {
        logger.log("Testing is rotation true case");
        String word = "waterbottle";
        String substring = "erbottlewat";
        Assert.assertTrue(instance.isRotation(word, substring));
    }

    @Test
    public void testIsRotationFalse() {
        logger.log("Testing is rotation false case");
        String word = "waterbottle";
        String substring = "erobttlewat";
        Assert.assertFalse(instance.isRotation(word, substring));
    }

}
