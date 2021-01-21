package chapter1.ArraysAndStringsTest;

import chapter1.ArraysAndStrings.ZeroMatrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testLogger.TestLogger;

public class ZeroMatrixTest {
    ZeroMatrix instance;
    TestLogger logger = new TestLogger(this);

    @Before
    public void setUp() {
        instance = new ZeroMatrix();
    }

    @Test
    public void testZeroMatrixTrue() {
        logger.log("Testing zero matrix true case");
        int[][] matrix = {{1, 2, 3}, {0, 5, 6}, {7, 8, 9}};
        int[][] expected = {{0, 2, 3}, {0, 0, 0}, {0, 8, 9}};
        instance.zeroMatrix(matrix);
        Assert.assertArrayEquals(expected, matrix);
    }

    @Test
    public void testZeroMatrixEdge() {
        logger.log("Testing zero matrix edge case");
        int[][] matrix = {{1}};
        instance.zeroMatrix(matrix);
        Assert.assertArrayEquals(matrix, matrix);
    }

    @Test
    public void testZeroMatrixTrueSecondMethod() {
        logger.log("Testing zero matrix true case for second method");
        int[][] matrix = {{1, 2, 3}, {0, 5, 6}, {7, 8, 9}};
        int[][] expected = {{0, 2, 3}, {0, 0, 0}, {0, 8, 9}};
        instance.setZero(matrix);
        Assert.assertArrayEquals(expected, matrix);
    }

    @Test
    public void testZeroMatrixTrueLessSpace() {
        logger.log("Testing zero matrix true case for less space method");
        int[][] matrix = {{1, 2, 3}, {0, 5, 6}, {7, 8, 9}};
        int[][] expected = {{0, 2, 3}, {0, 0, 0}, {0, 8, 9}};
        instance.setZeroLessSpace(matrix);
        Assert.assertArrayEquals(expected, matrix);
    }

}
