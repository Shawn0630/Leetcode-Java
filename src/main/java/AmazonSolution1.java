import java.util.Comparator;
import java.util.List;

public class AmazonSolution1 {

    public List<String> orderedJunctionBoxes(int numberOfBoxes,
                                             List<String> boxList)
    {
        boxList.sort((o1, o2) -> {
            String[] o1s = o1.split(" ");
            String[] o2s = o2.split(" ");

            if (isNumeric(o1s[1]) && isNumeric(o2s[1])) {
                return 0;
            } else if (isNumeric(o1s[1])) {
                return 1;
            } else if (isNumeric(o2s[1])) {
                return -1;
            } else {
                if (!o1.substring(o1.indexOf(" ") + 1).equals(o2.substring(o2.indexOf(" ") + 1))) {
                    return o1.substring(o1.indexOf(" ") + 1).compareTo(o2.substring(o2.indexOf(" ") + 1));
                } else {
                    return o1s[0].compareTo(o2s[0]);
                }
            }
        });

        return boxList;
    }

    private static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
