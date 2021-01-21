package chapter1.ArraysAndStringsTest;

import chapter1.ArraysAndStrings.RotateMatrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testLogger.TestLogger;

public class RotateMatrixTest {
    RotateMatrix instance;
    TestLogger logger = new TestLogger(this);

    @Before
    public void setUp() {
        instance = new RotateMatrix();
    }

    @Test
    public void testRotateTrue() {
        logger.log("Testing rotate matrix true case");
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Assert.assertArrayEquals(expected, instance.rotate90(matrix));
    }

    @Test
    public void testRotateEdge() {
        logger.log("Testing rotate matrix edge case");
        int[][] matrix = {{1}};
        Assert.assertArrayEquals(matrix, instance.rotate90(matrix));
    }


    @Test
    public void testRotateTrueInPlace() {
        logger.log("Testing rotate matrix true case in place");
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        instance.rotateInPlace(matrix);
        Assert.assertArrayEquals(expected, matrix);
    }

}
