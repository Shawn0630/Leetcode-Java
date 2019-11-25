import org.junit.Before;
import org.junit.Test;

public class RandomizedCollectionTest {
    RandomizedCollection randomizedCollection;

    @Before
    public void before() {
        randomizedCollection = new RandomizedCollection();
    }

    @Test
    public void test1() {
        randomizedCollection.insert(1);
        randomizedCollection.remove(1);
        randomizedCollection.insert(1);
    }

    @Test
    public void test2() {
        randomizedCollection.insert(4);
        randomizedCollection.insert(3);
        randomizedCollection.insert(4);
        randomizedCollection.insert(2);
        randomizedCollection.insert(4);
        randomizedCollection.remove(4);
        randomizedCollection.remove(3);
        randomizedCollection.remove(4);
        randomizedCollection.remove(4);
    }

    @Test
    public void test3() {
        randomizedCollection.insert(0);
        randomizedCollection.insert(1);
        randomizedCollection.insert(2);
        randomizedCollection.insert(3);
        randomizedCollection.insert(3);
        randomizedCollection.insert(2);
        randomizedCollection.remove(2);
        randomizedCollection.remove(3);
        randomizedCollection.remove(0);
    }

    @Test
    public void test4() {
        randomizedCollection.insert(0);
        randomizedCollection.remove(0);
        randomizedCollection.insert(-1);
        randomizedCollection.remove(0);
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
    }

}
