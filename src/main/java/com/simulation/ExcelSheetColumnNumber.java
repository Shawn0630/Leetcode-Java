package com.simulation;

public class ExcelSheetColumnNumber {
    // 1 <= columnTitle.length <= 7
    // consist of upper letter case only

    // AA
    // AB
    // ...AZ 26
    // BA
    //      26
    // CA
    // ..CZ 26
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for(char column : columnTitle.toCharArray()) {
            ans = ans * 26 + (column - 'A' + 1);
        }

        return ans;
    }


    public static void main(String args[]) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        excelSheetColumnNumber.titleToNumber("AA");
    }
}
