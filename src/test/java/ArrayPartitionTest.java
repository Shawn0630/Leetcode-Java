import org.junit.Test;

public class ArrayPartitionTest {

    ArrayPartition ap = new ArrayPartition();

    @Test
    public void test1(){
        ap.arrayPartition(new int[]{}, 9);
    }

    @Test
    public void test2() {
        ap.arrayPartition(new int[]{1}, 9);
    }

    @Test
    public void test3() {
        ap.arrayPartition(new int[]{12, 1, 1, 1, 2, 3, 4, 5, 6, 6, 6}, 6);
    }
}
