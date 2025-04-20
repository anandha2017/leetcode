package Leet0009_PalindromeNumber;

public class soln {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;

            int reverse = 0;
            int temp = x;
            while (temp != 0) {
                reverse = ((reverse * 10) + (temp % 10));
                temp /= 10;
            }
        
            return (reverse == x);
        }
    }
/* 
function isPalindrome(x: number): boolean {
    if (x < 0) {
        return false
    }
 
    let reverse = 0
    let temp = x
    while (temp != 0) {
        reverse = ((reverse * 10) + (temp % 10));
        temp = Math.trunc(temp / 10);
    }
    
    return (reverse == x)
};
 */
    public static void main(String[] args) {
        // Create an instance of the outer class
        soln outer = new soln();

        // Create an instance of the inner Solution class
        Solution solution = outer.new Solution();

        // Compare the result with the expected output
        System.out.println(solution.isPalindrome(121)==true); 
        System.out.println(solution.isPalindrome(-121)==false); 
        System.out.println(solution.isPalindrome(10)==false); 
    }
}