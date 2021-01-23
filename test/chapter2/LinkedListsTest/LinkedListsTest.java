package chapter2.LinkedListsTest;

import chapter2.LinkedLists.DeDupe;
import chapter2.LinkedLists.KtoLast;
import chapter2.LinkedLists.DeleteMiddleNode;
import chapter2.LinkedLists.Partition;
import chapter2.LinkedLists.SumLists;
import chapter2.LinkedLists.Palindrome;
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
    DeleteMiddleNode deleteMiddle;
    Partition partition;
    SumLists sumlists;
    Palindrome palindrome;
    TestLogger logger = new TestLogger(this);
    Node head;

    @Before
    public void setUp() {
        instance = new DeDupe();
        ktoLastInstance = new KtoLast();
        deleteMiddle = new DeleteMiddleNode();
        partition = new Partition();
        sumlists = new SumLists();
        palindrome = new Palindrome();
        head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(5);
        head.appendToTail(2);
        head.appendToTail(4);
        head.appendToTail(1);
        head.appendToTail(3);
        head.appendToTail(1);
        head.appendToTail(7);
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

    @Test
    public void testDeleteMiddleWithHead() {
        logger.log("Testing delete middle node withe head given");
        deleteMiddle.deleteMiddle(head);
    }

    @Test
    public void testPartition() {
        logger.log("Testing partition with using 2 linked lists");
        Node solution = partition.partition(head, 4);
    }

    @Test
    public void testPartitionRearrange() {
        logger.log("Testing partition with using rearrangement");
        Node solution = partition.partitionRearrange(head, 4);
    }

    @Test
    public void testSumListReverse() {
        logger.log("Testing sum list reverse");
        Node list1 = new Node(7);
        list1.appendToTail(1);
        list1.appendToTail(6);

        Node list2 = new Node(5);
        list2.appendToTail(9);
        list2.appendToTail(2);
        Node solution = sumlists.sumLists(list1, list2);
    }

    @Test
    public void testSumListReverseRecursive() {
        logger.log("Testing sum list reverse recursive");
        Node list1 = new Node(7);
        list1.appendToTail(1);
        list1.appendToTail(6);

        Node list2 = new Node(5);
        list2.appendToTail(9);
        list2.appendToTail(2);
        Node solution = sumlists.add2Lists(list1, list2);
    }

    @Test
    public void testSumListReverseRecursiveAddCarry() {
        logger.log("Testing sum list reverse recursive when number is carried over");
        Node list1 = new Node(7);
        list1.appendToTail(1);
        list1.appendToTail(6);

        Node list2 = new Node(5);
        list2.appendToTail(9);
        list2.appendToTail(5);
        Node solution = sumlists.add2Lists(list1, list2);
    }

    @Test
    public void testSumListForwardRecursive() {
        logger.log("Testing sum list forward recursive");
        Node list1 = new Node(6);
        list1.appendToTail(1);
        list1.appendToTail(7);

        Node list2 = new Node(5);
        list2.appendToTail(9);
        list2.appendToTail(5);
        Node solution = sumlists.add2ListsForward(list1, list2);
    }

    @Test
    public void testPalindromeReverse() {
        logger.log("Testing is palindrome using reverse check");
        Node list1 = new Node(0);
        list1.appendToTail(1);
        list1.appendToTail(2);
        list1.appendToTail(1);
        list1.appendToTail(0);
        Assert.assertTrue(palindrome.checkPalindrome(list1));
    }
}

