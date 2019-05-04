import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class IntersectionofTwoLinkedListsTest {

    IntersectionofTwoLinkedLists itll = new IntersectionofTwoLinkedLists();
    @Test
    public void test1() {
        IntersectionofTwoLinkedLists.ListNode a = new IntersectionofTwoLinkedLists.ListNode(1);
        IntersectionofTwoLinkedLists.ListNode b = new IntersectionofTwoLinkedLists.ListNode(2);
        IntersectionofTwoLinkedLists.ListNode c = new IntersectionofTwoLinkedLists.ListNode(3);
        b.next = c;

        assertThat(itll.getIntersectionNode(a, b), is(nullValue()));

    }
}
