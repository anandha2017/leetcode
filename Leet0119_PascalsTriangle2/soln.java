package Leet0119_PascalsTriangle2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class soln {

    class Solution {
        public List<Integer> getRow(int rowIndex) {

            List<List<Integer>> triangle = generate(rowIndex + 1);

            return triangle.getLast();
        }

        public List<List<Integer>> generate(int numRows) {

            List<List<Integer>> triangle = new ArrayList<>();

            if (numRows <= 0) {
                return triangle;
            }

            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            triangle.add(firstRow);

            for (int i = 1; i < numRows; i++) {
                List<Integer> prevRow = triangle.get(i - 1);
                List<Integer> currentRow = new ArrayList<>();

                currentRow.add(1);

                for (int j = 1; j < i; j++) {
                    currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
                }

                currentRow.add(1);
                triangle.add(currentRow);
            }

            return triangle;
        }
    }

    private static final int MAX_STRING_LENGTH = 50;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[92m";
    private static final String ANSI_RED = "\u001B[91m";

    private static String greenText(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    private static String redText(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    private static String truncateStr(String s, int maxLength) {
        if (s.length() <= maxLength) {
            return s;
        }
        return s.substring(0, maxLength - 3) + "...";
    }

    private static String truncateStr(String s) {
        return truncateStr(s, MAX_STRING_LENGTH);
    }

    private static boolean assertSolution(int rowNumber, Integer[] expected) {
        soln outer = new soln();
        Solution solution = outer.new Solution();

        List<Integer> outputList = solution.getRow(rowNumber);
        Integer[] output = outputList.toArray(new Integer[0]);

        boolean assertPass = Arrays.equals(output, expected);

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": Input: " + rowNumber +
                        ", Output: " + truncateStr(Arrays.toString(output)) +
                        ", Expected: " + truncateStr(Arrays.toString(expected)));

        return assertPass;
    }

    public static void main(String[] args) {

        // Base cases
        assertSolution(0, new Integer[] { 1 });
        assertSolution(1, new Integer[] { 1, 1 });

        // Small cases
        assertSolution(2, new Integer[] { 1, 2, 1 });
        assertSolution(3, new Integer[] { 1, 3, 3, 1 });
        assertSolution(4, new Integer[] { 1, 4, 6, 4, 1 });
        assertSolution(5, new Integer[] { 1, 5, 10, 10, 5, 1 });

        // Medium cases
        assertSolution(6, new Integer[] { 1, 6, 15, 20, 15, 6, 1 });
        assertSolution(7, new Integer[] { 1, 7, 21, 35, 35, 21, 7, 1 });
        assertSolution(10, new Integer[] { 1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1 });

        // Larger cases to test handling of larger numbers
        assertSolution(15,
                new Integer[] { 1, 15, 105, 455, 1365, 3003, 5005, 6435, 6435, 5005, 3003, 1365, 455, 105, 15, 1 });
        assertSolution(20, new Integer[] { 1, 20, 190, 1140, 4845, 15504, 38760, 77520, 125970, 167960, 184756, 167960,
                125970, 77520, 38760, 15504, 4845, 1140, 190, 20, 1 });

        // Edge cases
        assertSolution(30,
                new Integer[] { 1, 30, 435, 4060, 27405, 142506, 593775, 2035800, 5852925, 14307150, 30045015, 54627300,
                        86493225, 119759850, 145422675, 155117520, 145422675, 119759850, 86493225, 54627300, 30045015,
                        14307150, 5852925, 2035800, 593775, 142506, 27405, 4060, 435, 30, 1 });

        // Max constraint case
        assertSolution(33,
                new Integer[] { 1, 33, 528, 5456, 40920, 237336, 1107568, 4272048, 13884156, 38567100, 92561040,
                        193536720, 354817320, 573166440, 818809200, 1037158320, 1166803110, 1166803110, 1037158320,
                        818809200, 573166440, 354817320, 193536720, 92561040, 38567100, 13884156, 4272048, 1107568,
                        237336, 40920, 5456, 528, 33, 1 });
    }
}
