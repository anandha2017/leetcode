package Leet0202_HappyNumber;

import Leet0202_HappyNumber.ImprovedSoln.Solution;
import Leet0202_HappyNumber.ImprovedSoln.OptimizedSolution;

public class TestImprovedSolution {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[92m";
    private static final String ANSI_RED = "\u001B[91m";
    private static final String ANSI_BLUE = "\u001B[94m";

    private static String greenText(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    private static String redText(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    private static String blueText(String text) {
        return ANSI_BLUE + text + ANSI_RESET;
    }

    private static boolean testSolution(String solutionName, int input, boolean expected,
                                       java.util.function.Function<Integer, Boolean> solver) {
        boolean output = solver.apply(input);
        boolean assertPass = output == expected;

        String result = assertPass ? "PASS" : "FAIL";
        String formattedResult = assertPass ? greenText(result) : redText(result);

        System.out.println(
                formattedResult + " [" + solutionName + "]: " +
                        "Output: " + output +
                        ", Expected: " + expected +
                        ", Input: " + input);

        return assertPass;
    }

    public static void main(String[] args) {
        ImprovedSoln improvedSoln = new ImprovedSoln();
        Solution hashSetSolution = improvedSoln.new Solution();
        OptimizedSolution floydSolution = improvedSoln.new OptimizedSolution();

        System.out.println(blueText("=== Testing Improved Solutions ===\n"));

        // Test cases
        int[] testInputs = {1, 7, 2, 19, 4, 16, 37, 58, 89, 145, 42, 20, 23, 44, 100, 2147483647};
        boolean[] expectedOutputs = {true, true, false, true, false, false, false, false, false, false, false, false, true, true, true, false};

        int hashSetPassed = 0;
        int floydPassed = 0;
        int totalTests = testInputs.length;

        System.out.println(blueText("--- HashSet Solution (O(log n) space) ---"));
        for (int i = 0; i < testInputs.length; i++) {
            if (testSolution("HashSet", testInputs[i], expectedOutputs[i], hashSetSolution::isHappy)) {
                hashSetPassed++;
            }
        }

        System.out.println(blueText("\n--- Floyd's Cycle Detection (O(1) space) ---"));
        for (int i = 0; i < testInputs.length; i++) {
            if (testSolution("Floyd", testInputs[i], expectedOutputs[i], floydSolution::isHappy)) {
                floydPassed++;
            }
        }

        System.out.println(blueText("\n=== Summary ==="));
        System.out.println("HashSet Solution: " + greenText(hashSetPassed + "/" + totalTests) + " tests passed");
        System.out.println("Floyd Solution: " + greenText(floydPassed + "/" + totalTests) + " tests passed");

        if (hashSetPassed == totalTests && floydPassed == totalTests) {
            System.out.println(greenText("\n✓ All improved solutions working correctly!"));
        } else {
            System.out.println(redText("\n✗ Some tests failed!"));
        }
    }
}
