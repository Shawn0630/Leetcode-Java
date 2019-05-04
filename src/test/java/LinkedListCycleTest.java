import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListCycleTest {

    LinkedListCycle llc = new LinkedListCycle();

    @Test
    public void test1() {
        LinkedListCycle.ListNode node = new LinkedListCycle.ListNode(1);
        assertFalse(llc.hasCycle(node));
    }

    @Test
    public void test2() {
        LinkedListCycle.ListNode node1 = new LinkedListCycle.ListNode(1);
        LinkedListCycle.ListNode node2 = new LinkedListCycle.ListNode(2);
        node1.next = node2;
        node2.next = node1;
        assertTrue(llc.hasCycle(node1));
    }

    @Test
    public void test3() {
        LinkedListCycle.ListNode node = new LinkedListCycle.ListNode(1);
        node.next = node;
        assertTrue(llc.hasCycle(node));
    }


}
