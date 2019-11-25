import org.junit.Test;

import java.util.Arrays;

public class IDsOfPackageTest {

    IDsOfPackage id = new IDsOfPackage();

    @Test
    public void test1() {
        System.out.print(id.IDsOfPackages(110, Arrays.asList(20, 70, 90, 30, 60, 110)));
    }
}
