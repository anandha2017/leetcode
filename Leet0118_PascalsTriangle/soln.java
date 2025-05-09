package Leet0118_PascalsTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class soln {

    class Solution {
        public List<List<Integer>> generate(int numRows) {

            return null;
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

    /**
     * Converts a List<List<Integer>> to a formatted string representation
     *
     * @param nestedList The List<List<Integer>> to convert
     * @return A string representation of the nested list
     */
    public static String toStr(List<List<Integer>> nestedList) {
        if (nestedList == null) {
            return "null";
        }

        if (nestedList.isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < nestedList.size(); i++) {
            List<Integer> row = nestedList.get(i);
            sb.append("[");

            for (int j = 0; j < row.size(); j++) {
                sb.append(row.get(j));
                if (j < row.size() - 1) {
                    sb.append(",");
                }
            }

            sb.append("]");
            if (i < nestedList.size() - 1) {
                sb.append(",");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Populates a List<List<Integer>> with provided values
     *
     * @param values A 2D array of integers representing the values to populate
     * @return The populated List<List<Integer>>
     */
    public static List<List<Integer>> populateNestedList(Integer[][] values) {
        List<List<Integer>> result = new ArrayList<>();

        for (Integer[] row : values) {
            result.add(Arrays.asList(row));
        }

        return result;
    }

    /**
     * Compares two List<List<Integer>> to check if they are equal
     * Two nested lists are considered equal if they have the same structure
     * and all corresponding elements are equal
     *
     * @param list1 The first List<List<Integer>> to compare
     * @param list2 The second List<List<Integer>> to compare
     * @return true if the lists are equal, false otherwise
     */
    public static boolean isEqual(List<List<Integer>> list1, List<List<Integer>> list2) {
        // Check if both lists are null
        if (list1 == null && list2 == null) {
            return true;
        }

        // Check if one list is null but the other is not
        if (list1 == null || list2 == null) {
            return false;
        }

        // Check if the lists have the same size
        if (list1.size() != list2.size()) {
            return false;
        }

        // Compare each row
        for (int i = 0; i < list1.size(); i++) {
            List<Integer> row1 = list1.get(i);
            List<Integer> row2 = list2.get(i);

            // Check if the rows have the same size
            if (row1.size() != row2.size()) {
                return false;
            }

            // Compare each element in the row
            for (int j = 0; j < row1.size(); j++) {
                if (!Objects.equals(row1.get(j), row2.get(j))) {
                    return false;
                }
            }
        }

        // If all checks pass, the lists are equal
        return true;
    }

    private static boolean assertSolution(int numRows, Integer[][] expected) {
        soln outer = new soln();
        Solution solution = outer.new Solution();

        List<List<Integer>> expected2DList = populateNestedList(expected);
        List<List<Integer>> output = solution.generate(numRows);

        boolean assertPass = isEqual(output, expected2DList);

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + ": Input: " + numRows +
                        ", Output: " + truncateStr(toStr(output)) +
                        ", Expected: " + truncateStr(toStr(expected2DList)));

        return assertPass;
    }

    public static void main(String[] args) {

        assertSolution(1, new Integer[][] {
                { 1 }
        });

        assertSolution(3, new Integer[][] {
                { 1 },
                { 1, 1 },
                { 1, 2, 1 }
        });

        assertSolution(5, new Integer[][] {
                { 1 },
                { 1, 1 },
                { 1, 2, 1 },
                { 1, 3, 3, 1 },
                { 1, 4, 6, 4, 1 }
        });

        assertSolution(7, new Integer[][] {
                { 1 },
                { 1, 1 },
                { 1, 2, 1 },
                { 1, 3, 3, 1 },
                { 1, 4, 6, 4, 1 },
                { 1, 5, 10, 10, 5, 1 },
                { 1, 6, 15, 20, 15, 6, 1 }
        });

        assertSolution(10, new Integer[][] {
                { 1 },
                { 1, 1 },
                { 1, 2, 1 },
                { 1, 3, 3, 1 },
                { 1, 4, 6, 4, 1 },
                { 1, 5, 10, 10, 5, 1 },
                { 1, 6, 15, 20, 15, 6, 1 },
                { 1, 7, 21, 35, 35, 21, 7, 1 },
                { 1, 8, 28, 56, 70, 56, 28, 8, 1 },
                { 1, 9, 36, 84, 126, 126, 84, 36, 9, 1 }
        });
    }
}
