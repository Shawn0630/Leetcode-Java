import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MiddleOfLinkedListTest {

    MiddleOfLinkedList ml;

    @Before
    public void before() {
        ml = new MiddleOfLinkedList();
    }

    @Test
    public void test1() {
        MiddleOfLinkedList.ListNode node1 = new MiddleOfLinkedList.ListNode(1);
        MiddleOfLinkedList.ListNode node2 = new MiddleOfLinkedList.ListNode(2);
        MiddleOfLinkedList.ListNode node3 = new MiddleOfLinkedList.ListNode(3);
        MiddleOfLinkedList.ListNode node4 = new MiddleOfLinkedList.ListNode(4);
        MiddleOfLinkedList.ListNode node5 = new MiddleOfLinkedList.ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        assertEquals(3, ml.middleNode(node1).val);
    }

    @Test
    public void test2() {
        MiddleOfLinkedList.ListNode node1 = new MiddleOfLinkedList.ListNode(1);
        MiddleOfLinkedList.ListNode node2 = new MiddleOfLinkedList.ListNode(2);
        MiddleOfLinkedList.ListNode node3 = new MiddleOfLinkedList.ListNode(3);
        MiddleOfLinkedList.ListNode node4 = new MiddleOfLinkedList.ListNode(4);
        MiddleOfLinkedList.ListNode node5 = new MiddleOfLinkedList.ListNode(5);
        MiddleOfLinkedList.ListNode node6 = new MiddleOfLinkedList.ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        assertEquals(4, ml.middleNode(node1).val);
    }
}
