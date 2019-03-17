import org.junit.Test;

public class MyStackTest {
    @Test
    public void test1() {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.top();   // returns 2
        stack.pop();   // returns 2
        stack.empty(); // returns false
    }
}
