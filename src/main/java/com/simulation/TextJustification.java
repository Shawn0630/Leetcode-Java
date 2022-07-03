package com.simulation;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        List<String> strPerLine = new ArrayList<>();
        int curWidth = 0;
        int stringWidTotal = 0;
        for(String word : words) {
            if (curWidth == 0) {
                curWidth = word.length();
            } else {
                curWidth += (1 + word.length());
            }
            stringWidTotal += word.length();
            strPerLine.add(word);
            if (curWidth > maxWidth) {
                strPerLine.remove(strPerLine.size() - 1);
                String str = fullJustify(strPerLine, maxWidth, stringWidTotal - word.length());
                ans.add(str);
                curWidth = word.length();
                stringWidTotal = word.length();
                strPerLine.clear();
                strPerLine.add(word);
            }
        }
        ans.add(leftJustify(strPerLine, maxWidth));


        return ans;
    }

    // 3 + 1  +  4  +  10
    // 3 + 3 + 4
    // 3    4   2  10
    // 3
    // because the last line must be left-justified instead of fully-justified.
    private String fullJustify(List<String> strings, int maxWidth, int wordLength) {
        StringBuilder sb = new StringBuilder();
        if (strings.size() > 1) {
            int space = (maxWidth - wordLength) / (strings.size() - 1);
            int settleForLess = (maxWidth - wordLength) % (strings.size() - 1);
            for(String str : strings) {
                sb.append(str);
                if (sb.length() < maxWidth) {
                    for (int i = 0; i < space; i++) {
                        sb.append(" ");
                    }
                    if (settleForLess > 0) {
                        sb.append(" ");
                        settleForLess--;
                    }
                }
            }
        } else {
            sb.append(strings.get(0));
        }

        while (sb.length() < maxWidth) {
            sb.append(" ");
        }

        return sb.toString();
    }

    private String leftJustify(List<String> strings, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for(String str : strings) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str);
        }
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        textJustification.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }
}
