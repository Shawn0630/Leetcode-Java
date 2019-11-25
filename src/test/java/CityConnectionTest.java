import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CityConnectionTest {

    CityConnection cc = new CityConnection();

    @Test
    public void test1() {
        CityConnection.Connection c1 = new CityConnection.Connection("A", "D", 1);
        CityConnection.Connection c2 = new CityConnection.Connection("A", "B", 3);
        CityConnection.Connection c3 = new CityConnection.Connection("D", "B", 3);
        CityConnection.Connection c4 = new CityConnection.Connection("B", "C", 1);
        CityConnection.Connection c5 = new CityConnection.Connection("C", "D", 1);
        CityConnection.Connection c6 = new CityConnection.Connection("E", "D", 6);
        CityConnection.Connection c7 = new CityConnection.Connection("C", "E", 5);
        CityConnection.Connection c8 = new CityConnection.Connection("C", "F", 4);
        CityConnection.Connection c9 = new CityConnection.Connection("E", "F", 2);
        List<CityConnection.Connection> list = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9));
        List<CityConnection.Connection> result = cc.lowestCost(list);
        List<CityConnection.Connection> result2 = cc.lowestCost2(list);
        for (CityConnection.Connection conn : result) {
            System.out.println(conn.city1 + "-" + conn.cost + "-" + conn.city2);
        }
        for (CityConnection.Connection conn : result2) {
            System.out.println(conn.city1 + "-" + conn.cost + "-" + conn.city2);
        }
    }
}
