package Leet0168_ExcelSheetColumnTitle;

public class Soln {
    class Solution {
        public String convertToTitle(int columnNumber) {

            String digits = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String result = "";
            int remainder = 0;

            while (columnNumber > 0) {
                columnNumber--;
                remainder = columnNumber % 26;
                result = digits.charAt(remainder) + result;
                columnNumber = columnNumber / 26;
            }

            return result;
        }
    }
}