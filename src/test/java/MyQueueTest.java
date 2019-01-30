import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

public class MyQueueTest {

    MyQueue queue;

    @Before
    public void setup(){
        queue = new MyQueue();
    }

    @Test
    public void test1() throws Exception {
        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.peek());  // returns 1
        assertEquals(1, queue.pop());   // returns 1
        assertFalse(queue.empty()); // returns false
    }
}
