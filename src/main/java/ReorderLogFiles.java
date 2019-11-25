import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) {
            return logs;
        }

        List<String> numberLog = new ArrayList<>();
        List<String> alphaLog = new ArrayList<>();

        for (String s : logs) {
            String[] ss = s.split(" ");
            if (isNumeric(ss[1])) numberLog.add(s);
            else alphaLog.add(s);
        }

        alphaLog.sort((o1, o2) -> {
            String[] o1s = o1.split(" ");
            String[] o2s = o2.split(" ");
            int o1_index = 1;
            int o2_index = 1;

            while (o1_index < o1s.length && o2_index < o2s.length && o1s[o1_index].equals(o2s[o2_index])) {
                o1_index++;
                o2_index++;
            }
            if (o1_index < o1s.length && o2_index < o2s.length) {
                return o1s[o1_index].compareTo(o2s[o2_index]);
            } else if (o1_index < o1s.length) {
                return -1;
            } else if (o2_index < o2s.length){
                return 1;
            } else {
                return o1s[0].compareTo(o2s[0]);
            }
        });

        String[] res = new String[logs.length];
        int logCount = 0;
        for(String log: alphaLog) {
            res[logCount++] = log;
        }
        for(String log: numberLog) {
            res[logCount++] = log;
        }

        return res;
    }


    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}


