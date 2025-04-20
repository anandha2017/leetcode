
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

/* class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False

        reverse = 0
        temp = x
        while temp != 0:
            reverse = (reverse * 10) + temp % 10
            temp = temp // 10 

        return (reverse == x)


solution = Solution()
print(solution.isPalindrome(121)   == True)    # example 1
print(solution.isPalindrome(-121)  == False)   # example 2
print(solution.isPalindrome(10)    == False)   # example 3
 */

console.log(isPalindrome(121)==true)
console.log(isPalindrome(-121)==false)
console.log(isPalindrome(10)==false)