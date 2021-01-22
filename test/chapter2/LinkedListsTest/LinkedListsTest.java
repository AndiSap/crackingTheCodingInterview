package chapter2.LinkedListsTest;

import chapter2.LinkedLists.DeDupe;
import chapter2.LinkedLists.KtoLast;
import chapter2.LinkedLists.LinkedListBasics.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testLogger.TestLogger;

/**
 * @todo: add expected node values so results can be compared
 */
public class LinkedListsTest {
    DeDupe instance;
    KtoLast ktoLastInstance;
    TestLogger logger = new TestLogger(this);
    Node head;

    @Before
    public void setUp() {
        instance = new DeDupe();
        ktoLastInstance = new KtoLast();
        head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(4);
        head.appendToTail(1);
    }

    @Test
    public void testDedupeTrue() {
        logger.log("Testing dedupe true case");
        instance.dedupe(head);
    }

    @Test
    public void testDedupeTrueRunner() {
        logger.log("Testing dedupe true case with 2 pointers");
        instance.dedupeRunner(head);
    }

    @Test
    public void testKToLastTrue() {
        logger.log("Testing k to last true case");
        Node ktolast = ktoLastInstance.findKToLast(head, 2);
    }

    @Test
    public void testKToLastRecursive() {
        logger.log("Testing k to last true case recursive");
        ktoLastInstance.kToLastRecursive(head, 2);
    }

    @Test
    public void testKToLastRecursiveNode() {
        logger.log("Testing k to last true case recursive which returns node");
        Node ktoLast = ktoLastInstance.ktoLastNode(head, 2);
    }

    @Test
    public void testKToLastIterative() {
        logger.log("Testing k to last true case iterative with 2 pointers");
        Node ktoLast = ktoLastInstance.kToLastWithPointers(head, 3);
    }

}

