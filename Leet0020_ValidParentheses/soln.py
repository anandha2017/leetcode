class Solution:
    def isValid(self, s: str) -> bool:
        d = {')':'(',']':'[','}':'{'}
        closingTimeList = [')',']','}']
        stack = []

        for char in s:
            stack.append(char)
            if char in closingTimeList:
                stack.pop()

                if len(stack) == 0:
                    return False

                if stack.pop() != d.get(char):
                    return False
 
        if len(stack) > 0:
            return False
        
        return True        
""" 
| Input    | Output  |
| -------- | ------- |
| `()`     | `true`  |
| `()[]{}` | `true`  |
| `(]`     | `false` |
| `([])`   | `true`  |

- `s` consists exclusively of the characters `()[]{}`.

 """
solution = Solution()

print(solution.isValid("()") == True)
print(solution.isValid("()[]{}") == True)
print(solution.isValid("(]") == False)
print(solution.isValid("([])") == True)
print(solution.isValid(")()") == False)
print(solution.isValid(")") == False)
print(solution.isValid("(") == False)

