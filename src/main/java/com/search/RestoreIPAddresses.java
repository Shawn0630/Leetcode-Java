package com.search;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return ans;
        }

        dfs(3, 0, s, "", ans);

        return ans;
    }

    private static void dfs(int count, int cur, String s, String sb, List<String> ans) {
        if (count == 0) {
            if (s.length() - 1 - cur >= 0 && s.length() - 1 - cur <= 3) {
                int num = 0, i;
                String str = "";
                for (i = cur; i < s.length(); i++) {
                    char c = s.charAt(i);
                    str = str + c;
                    num = num * 10 + c - '0';
                }

                if (str.length() == 1 || (str.length() > 1 && str.charAt(0) != '0' && num <= 255) && i == s.length()) {
                    ans.add(sb + str);
                }
            }
            return;
        }


        int num = 0;
        for(int i = cur; i < cur + 3 && i < s.length(); i++) {
            char c = s.charAt(i);
            num = num * 10 + c - '0';
            sb = sb + c;
            if (num <= 255) {
                dfs(count - 1, i + 1, s, sb + '.', ans);
                if (i == cur && c == '0') break;
            }
        }
    }

    public static void main(String[] args) {
        List<String> ans = restoreIpAddresses("101023");
//        List<String> ans = restoreIpAddresses("010010");
        System.out.println(ans);
    }
}
