package com.search;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] cs = s.toCharArray();
        int[] result = new int[cs.length + 1];
        if (cs[0] == '0') {
            return 0;
        }

        result[0] = 1;
        result[1] = 1;

        for(int i = 1; i < cs.length; i++) {
            if (cs[i] != '0') {
                result[i + 1] = result[i];
            } else {
                result[i + 1] = 0;
            }
            if (cs[i - 1] == '1'
                || (cs[i - 1] == '2' && cs[i] <= '6')) {
                result[i + 1] += result[i - 1];
            }
        }

        return result[result.length - 1];
    }


    public int numDecodings2(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        char[] cs = s.toCharArray();

        long[] dp = new long[cs.length + 1];

        dp[0] = 1;
        if (s.charAt(0) == '*') {
            dp[1] = 9;
        } else {
            dp[1] = 1;
        }

        int mod = 1000000007;

        for(int i = 1; i < cs.length; i++) {
            if (Character.isDigit(cs[i])) {
                if (cs[i] != '0') {
                    dp[i + 1] = dp[i];
                } else {
                    dp[i + 1] = 0;
                }

                if (cs[i - 1] == '1'
                        || (cs[i - 1] == '2' && cs[i] <= '6')) {
                    dp[i + 1] += dp[i - 1] % mod;
                } else if (cs[i - 1] == '*') {
                    if (cs[i] >= '0' && cs[i] <= '6') {
                        dp[i + 1] +=  2 * dp[i - 1] % mod;
                    } else if (cs[i] >= '7' && cs[i] <= '9') {
                        dp[i + 1] += 1 * dp[i - 1] % mod;
                    }
                }
            } else if (cs[i] == '*') {
                dp[i + 1] = 9 * dp[i] % mod;

                if (cs[i - 1] == '1') {
                    dp[i + 1] += 9 * dp[i - 1] % mod;
                } else if (cs[i - 1] == '2') {
                    dp[i + 1] += 6 * dp[i - 1] % mod;
                } else if (cs[i - 1] == '*') {
                    dp[i + 1] += 15 * dp[i - 1] % mod;
                }
            }
        }

        return (int)(dp[dp.length - 1] % mod);
    }

    public int numDecodings3(String s) {
        char c[] = s.toCharArray();
        long[] dp = new long[s.length() + 1];

        int mod = 1000000007;

        for(int i = 0; i < dp.length; i++) {
            if(i == 0) {
                dp[i] = 1;
                continue;
            }

            char cur = c[i - 1];

            if(i == 1) {
                if(cur == '*') {
                    dp[i] = 9;
                }else if(cur == '0') {
                    dp[i] = 0;
                }else {
                    dp[i] = 1;
                }
                continue;
            }

            //case: []AB
            //case: [...]AB
            if (i-2 >= 0) {
                char pre = c[i - 2];
                //dp[i] = c[i-1] * dp[i-1] + c[i-2][i-1] * dp[i - 2];

                //cases for c[i - 1]
                //if c[i - 1] == '*', a = 9
                //if c[i - 1] == '0', a = 0
                //else a = 1
                int a = 0;
                if(cur == '*') {
                    a = 9;
                } else if (cur == '0') {
                    a = 0;
                } else {
                    a = 1;
                }

                dp[i] = a * dp[i - 1] % mod;

                int b = 0;

                //case: **
                if(pre=='*' && cur=='*') {
                    b = 15;

                    //case: 1*
                }else if(pre == '1' && cur == '*'){
                    b = 9;

                    //case: 2*
                }else if (pre == '2' && cur == '*'){
                    b = 6;

                    //case: *[0-6]
                }else if (pre == '*' && cur >= '0' && cur <= '6'){
                    b = 2;

                    //case: *[7-9]
                }else if (pre == '*' && cur > '6') {
                    b = 1;

                    //case: none *, none *
                } else if (pre != '*' && cur != '*'){
                    //shoud check if it's in range;
                    int val = (pre - '0') * 10 + (cur - '0');
                    if(val >= 10 && val <= 26) {
                        b = 1;
                    }
                }



                dp[i] += b * dp[i - 2] % mod;


            }

        }
        return (int)(dp[dp.length - 1] % mod );
    }

}
