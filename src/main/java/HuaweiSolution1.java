import java.util.ArrayList;
import java.util.List;

public class HuaweiSolution1 {

    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
        if (items < 0) {
            return -1;
        }

        int counter = 0;

        while(availableLargePackages > 0 && items > 0) {
            if (items < 5) {
                break;
            }
            items -= 5;
            counter++;
            availableLargePackages--;
        }

        while(availableSmallPackages > 0 && items > 0) {
            items -= 1;
            counter++;
            availableSmallPackages--;
        }

        return items > 0 ? -1 : counter;
    }

    public static int[] flipShift(int a, int b) {
        //
        // Implement your solution here
        //
        List<Integer> aBin = new ArrayList<>();
        List<Integer> bBin = new ArrayList<>();
        bin(a, aBin);
        bin(b, bBin);

        int[] result = new int[3];

        int nextA = nextPower2(a);
        int halfA = nextA / 2;
        int nextB = nextPower2(b);
        int halfB = nextB / 2;
        List<Integer> naBin = new ArrayList<>();
        List<Integer> nbBin = new ArrayList<>();
        bin(nextA - a > a - halfA ? halfA : nextA, naBin);
        bin(nextB - b > b - halfB ? halfB : nextB, nbBin);

        result[0] = compareDiff(aBin, naBin);
        result[1] = compareDiff(bBin, nbBin);
        result[2] = numberToShift(nextA - a > a - halfA ? halfA : nextA, nextB - b > b - halfB ? halfB : nextB);


        return result;
    }

    public static int nextPower2(int x) {
        /*
        *
        * x     =    0000 0001    0001 0001    0001 0000
        * x - 1 =    0000 0000    0001 0000    0000 1111
        * x - 1 >> 1 0000 0000    0000 1000    0000 0111
        *
        * */
        x = x - 1;
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return x + 1;
    }

    public static void bin(int n, List<Integer> array) {
        if (n > 1) bin(n / 2, array);
        array.add(n % 2);
    }

    public static int compareDiff(List<Integer> a, List<Integer> b) {
        if (a.size() > b.size()) {
            return compareDiff(b, a);
        }

        int counter = 0;
        for(int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                counter++;
            }
        }

        for(int i = a.size(); i < b.size(); i++) {
            counter++;
        }

        return counter;
    }

    public static int numberToShift(int a, int b) {
        int counter = 0;
        while (a != b) {
            a = a * 2;
            counter++;
        }

        return counter;
    }

}
