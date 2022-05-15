package com.interviews.dropbox.oa;

import java.util.ArrayList;
import java.util.List;

public class MessageVisualizer {
    public String[] visualize(String[][] messages, int width, int userWidth) {
        String border = buildBorder(width);
        List<String> strings = new ArrayList<>();

        strings.add(border);

        for(String[] message : messages) {
            String id = message[0];
            String m = message[1];
            String[] words = m.split(" ");

            // hello 3
            // hel 0 + 3
            // lo
            int idx = 0;
            while (idx < words.length) {
                StringBuilder sb = new StringBuilder();
                // infinite loop if word.length > usrWidth
                while (idx < words.length && sb.length() + words[idx].length() <= userWidth) {
                    sb.append(words[idx]);
                    sb.append(" ");
                    idx++;
                }
                sb.deleteCharAt(sb.length() - 1);
                strings.add(buildMessage(sentenceBuilder(width), id, sb.toString()));
            }
        }

        strings.add(border);

        return strings.toArray(new String[]{});
    }

    private String buildMessage (StringBuilder sentenceBuilder, String id, String message) {
        if (id.equals("1")) {
            sentenceBuilder.replace(1, message.length() + 1, message);
        } else { // id.equals("2");
            sentenceBuilder.replace(sentenceBuilder.length() - 1 - message.length(), sentenceBuilder.length() - 1, message); // length 15, 0 - 14, 3 - 11(15-1-3 - 13 [11, 14) 11, 12, 13
        }

        return sentenceBuilder.toString();
    }

    private StringBuilder sentenceBuilder(int width) {
        StringBuilder sb = new StringBuilder();
        sb.append('|');
        for(int i = 0; i < width - 2; i++) {
            sb.append(' ');
        }
        sb.append('|');

        return sb;
    }

    private String buildBorder(int width) {
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        for(int i = 0; i < width - 2; i++) {
            sb.append('*');
        }
        sb.append('+');

        return sb.toString();
    }

    public static void main(String[] args) {
        String[][] messages = new String[][] {
                {"1", "Hello how r u"},
                {"2", "good ty"},
                {"2", "u"},
                {"1", "me too bro"}
        };

        MessageVisualizer messageVisualizer = new MessageVisualizer();
        String[] ans = messageVisualizer.visualize(messages, 15, 5);

        for(String s : ans) {
            System.out.println(s);
        }
    }
}
