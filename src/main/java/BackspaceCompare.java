public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {

/*
*
*
*   Method 1: StringBuilder
*
* */
//        int sp = 0;
//        int tp = 0;
//
//        StringBuilder SB = new StringBuilder(S);
//        StringBuilder TB = new StringBuilder(T);
//
//        for (int i = 0; i < S.length(); i++) {
//            if (S.charAt(i) == '#') {
//                if (sp > 0) {
//                    sp--;
//                }
//            } else {
//                SB.setCharAt(sp, S.charAt(i));
//                sp++;
//            }
//        }
//
//        for (int i = 0; i < T.length(); i++) {
//            if (T.charAt(i) == '#') {
//                if (tp > 0) {
//                    tp--;
//                }
//            } else {
//                TB.setCharAt(tp, T.charAt(i));
//                tp++;
//            }
//        }
//
//        return SB.toString().substring(0, sp).equals(TB.toString().substring(0, tp));

/*
*
*  Method 2: Reverse String
*
* */

    int indexS = S.length() - 1;
    int indexT = T.length() - 1;
    int skipT = 0;
    int skipS = 0;

    while (indexS >= 0 || indexT >= 0) {
        while(indexS >= 0) {
            if (S.charAt(indexS) == '#') {
                skipS++;
                indexS--;
            } else if (skipS > 0) {
                indexS--;
                skipS--;
            } else {
                break;
            }
        }

        while (indexT >= 0) {
            if (T.charAt(indexT) == '#') {
                skipT++;
                indexT--;
            } else if (skipT > 0) {
                indexT--;
                skipT--;
            } else {
                break;
            }
        }

        if (indexS >= 0 && indexT >= 0 && S.charAt(indexS) != T.charAt(indexT)) {
            return false;
        }
        if (indexS >= 0 != indexT >= 0) {
            return false;
        }
        indexT--;
        indexS--;
    }

    return true;

    }
}
