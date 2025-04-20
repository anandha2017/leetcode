struct Solution;

impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        // Negative numbers or numbers ending in 0 (but not 0 itself) cannot be palindromes
        if x < 0 || (x % 10 == 0 && x != 0) {
            return false;
        }
        
        let mut n = x;
        let mut reverted: i32 = 0;
        
        // Only reverse half of the digits
        while n > reverted {
            reverted = reverted * 10 + n % 10;
            n /= 10;
        }
        
        // For even-length numbers: n == reverted
        // For odd-length numbers: n == reverted/10 (middle digit ignored)
        n == reverted || n == reverted / 10
    }
}

/* 
impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        if x < 0 {
            return false;
        }

        let mut reverse = 0;
        let mut temp = x;
        while temp != 0 {
            reverse = (reverse * 10) + (temp % 10);
            temp /= 10;
        }
        
        return reverse == x;
    }
}
 */
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

fn main() {

    println!("{}", Solution::is_palindrome(121) == true);
    println!("{}", Solution::is_palindrome(-121) == false);
    println!("{}", Solution::is_palindrome(10) == false);
    println!("{}", Solution::is_palindrome(0) == true);
    println!("{}", Solution::is_palindrome(8) == true);
}