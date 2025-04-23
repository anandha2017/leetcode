content = """# Valid Parentheses

Given a string `s` containing only the characters `(`, `)`, `{`, `}`, `[` and `]`, determine whether the input string is valid.

## Criteria

- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every closing bracket must have a corresponding opening bracket of the same type.

## Examples

| Input    | Output  |
| -------- | ------- |
| `()`     | `true`  |
| `()[]{}` | `true`  |
| `(]`     | `false` |
| `([])`   | `true`  |

## Constraints

- `1 <= s.length <= 10^4`
- `s` consists exclusively of the characters `()[]{}`.
