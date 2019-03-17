import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RemoveNElementTest {

    RemoveNElement rne;

    @Before
    public void before() {
        rne = new RemoveNElement();
    }

    @Test
    public void test1() {
        RemoveNElement.ListNode node1 = new RemoveNElement.ListNode(1);
        RemoveNElement.ListNode node2 = new RemoveNElement.ListNode(2);
        node1.next = node2;
        node1 = rne.removeNElment(node1, 3);
        assertEquals(2, node1.next.val);

    }

    @Test
    public void test2() {
        RemoveNElement.ListNode node1 = new RemoveNElement.ListNode(1);
        RemoveNElement.ListNode node2 = new RemoveNElement.ListNode(2);
        node1.next = node2;
        node1 = rne.removeNElment(node1, 1);
        assertEquals(null, node1.next);

    }

    @Test
    public void test3() {
        RemoveNElement.ListNode node1 = new RemoveNElement.ListNode(1);
        RemoveNElement.ListNode node2 = new RemoveNElement.ListNode(2);
        RemoveNElement.ListNode node3 = new RemoveNElement.ListNode(3);
        RemoveNElement.ListNode node4 = new RemoveNElement.ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1 = rne.removeNElment(node1, 2);
        assertEquals(4, node2.next.val);

    }

    @Test
    public void test4() {
        RemoveNElement.ListNode node1 = new RemoveNElement.ListNode(1);
        RemoveNElement.ListNode node2 = new RemoveNElement.ListNode(2);
        RemoveNElement.ListNode node3 = new RemoveNElement.ListNode(3);
        RemoveNElement.ListNode node4 = new RemoveNElement.ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1 = rne.removeNElment(node1, 6);
        assertEquals(3, node2.next.val);

    }
}
