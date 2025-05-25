# Valid Phone Numbers - LeetCode #193

## Problem Statement

Given a text file file.txt that contains a list of phone numbers (one per line), write a one-liner bash script to print all valid phone numbers. You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx.

## Valid Formats

**Format 1:** `(xxx) xxx-xxxx`
**Format 2:** `xxx-xxx-xxxx`

Where `x` represents a digit (0-9).

## Visual Pattern Breakdown

```
Format 1: (xxx) xxx-xxxx
          ╰──┬─╯ ╰─┬╯ ╰─┬─╯
             3    3    4
          digits digits digits

Format 2: xxx-xxx-xxxx
          ╰┬╯ ╰─┬╯ ╰─┬─╯
           3   3    4
        digits digits digits
```

## Example Input File (file.txt)

```
987-123-4567
123 456 7890
(123) 456-7890
555-555-55555
(555) 555-5555
123-456-789
(123)456-7890
(123) 456 7890
555.123.4567
phone: (555) 123-4567
+44 207 123 4567
1234567890
(123) 456-7890 ext 123
```

## Expected Output

```
987-123-4567
(123) 456-7890
(555) 555-5555
```

## Pattern Analysis

### Valid Examples
- `987-123-4567` ✅ (Format 2: xxx-xxx-xxxx)
- `(123) 456-7890` ✅ (Format 1: (xxx) xxx-xxxx)
- `(555) 555-5555` ✅ (Format 1: (xxx) xxx-xxxx)

### Invalid Examples
- `123 456 7890` ❌ (spaces instead of hyphens)
- `555-555-55555` ❌ (too many digits in last group)
- `123-456-789` ❌ (too few digits in last group)
- `(123)456-7890` ❌ (missing space after closing parenthesis)
- `(123) 456 7890` ❌ (space instead of hyphen in middle)
- `555.123.4567` ❌ (dots instead of hyphens)
- `phone: (555) 123-4567` ❌ (contains additional text)
- `+44 207 123 4567` ❌ (international format)
- `1234567890` ❌ (no formatting)
- `(123) 456-7890 ext 123` ❌ (contains extension)

## Regular Expression Components

### For Format 1: `(xxx) xxx-xxxx`
- `(` - literal opening parenthesis
- `[0-9]{3}` - exactly 3 digits
- `)` - literal closing parenthesis
- ` ` - single space
- `[0-9]{3}` - exactly 3 digits
- `-` - literal hyphen
- `[0-9]{4}` - exactly 4 digits

### For Format 2: `xxx-xxx-xxxx`
- `[0-9]{3}` - exactly 3 digits
- `-` - literal hyphen
- `[0-9]{3}` - exactly 3 digits
- `-` - literal hyphen
- `[0-9]{4}` - exactly 4 digits

## Key Considerations

1. **Line Anchors**: Use `^` and `$` to ensure the entire line matches the pattern exactly
2. **Character Classes**: `[0-9]` matches any single digit
3. **Quantifiers**: `{n}` specifies exactly n occurrences
4. **Literal Characters**: Parentheses, spaces, and hyphens must be matched literally
5. **OR Logic**: Use `|` to match either format
6. **Escaping**: Some regex flavours require escaping certain characters

## Test Cases

### Edge Cases to Consider
- Lines with leading/trailing whitespace (shouldn't exist per problem statement)
- Empty lines
- Lines with partial matches
- Lines with valid patterns embedded in other text

### Additional Test Examples

**Input:**
```
(987) 654-3210
123-ABC-4567
(555) 123-4567
999-888-7777
(111) 222-3333 x456
```

**Expected Output:**
```
(987) 654-3210
(555) 123-4567
999-888-7777
```

## Bash Tools Available

- `grep` - pattern matching
- `awk` - text processing
- `sed` - stream editing
- `egrep` - extended regular expressions

## Solution

Here's the one-liner bash script solution:

```bash
grep -E "^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$" file.txt
```

### Alternative Solutions

**Using extended regex with egrep:**
```bash
egrep "^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$" file.txt
```

**Using basic grep (more verbose):**
```bash
grep "^\(\([0-9]\{3\}\) \|[0-9]\{3\}-\)[0-9]\{3\}-[0-9]\{4\}$" file.txt
```

**Using awk:**
```bash
awk '/^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$/' file.txt
```

## Solution Breakdown

The regex pattern `^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}# Valid Phone Numbers - LeetCode #193

## Problem Statement

Given a text file file.txt that contains a list of phone numbers (one per line), write a one-liner bash script to print all valid phone numbers. You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx.

## Valid Formats

**Format 1:** `(xxx) xxx-xxxx`
**Format 2:** `xxx-xxx-xxxx`

Where `x` represents a digit (0-9).

## Visual Pattern Breakdown

```
Format 1: (xxx) xxx-xxxx
          ╰──┬─╯ ╰─┬╯ ╰─┬─╯
             3    3    4
          digits digits digits

Format 2: xxx-xxx-xxxx
          ╰┬╯ ╰─┬╯ ╰─┬─╯
           3   3    4
        digits digits digits
```

## Example Input File (file.txt)

```
987-123-4567
123 456 7890
(123) 456-7890
555-555-55555
(555) 555-5555
123-456-789
(123)456-7890
(123) 456 7890
555.123.4567
phone: (555) 123-4567
+44 207 123 4567
1234567890
(123) 456-7890 ext 123
```

## Expected Output

```
987-123-4567
(123) 456-7890
(555) 555-5555
```

## Pattern Analysis

### Valid Examples
- `987-123-4567` ✅ (Format 2: xxx-xxx-xxxx)
- `(123) 456-7890` ✅ (Format 1: (xxx) xxx-xxxx)
- `(555) 555-5555` ✅ (Format 1: (xxx) xxx-xxxx)

### Invalid Examples
- `123 456 7890` ❌ (spaces instead of hyphens)
- `555-555-55555` ❌ (too many digits in last group)
- `123-456-789` ❌ (too few digits in last group)
- `(123)456-7890` ❌ (missing space after closing parenthesis)
- `(123) 456 7890` ❌ (space instead of hyphen in middle)
- `555.123.4567` ❌ (dots instead of hyphens)
- `phone: (555) 123-4567` ❌ (contains additional text)
- `+44 207 123 4567` ❌ (international format)
- `1234567890` ❌ (no formatting)
- `(123) 456-7890 ext 123` ❌ (contains extension)

## Regular Expression Components

### For Format 1: `(xxx) xxx-xxxx`
- `(` - literal opening parenthesis
- `[0-9]{3}` - exactly 3 digits
- `)` - literal closing parenthesis
- ` ` - single space
- `[0-9]{3}` - exactly 3 digits
- `-` - literal hyphen
- `[0-9]{4}` - exactly 4 digits

### For Format 2: `xxx-xxx-xxxx`
- `[0-9]{3}` - exactly 3 digits
- `-` - literal hyphen
- `[0-9]{3}` - exactly 3 digits
- `-` - literal hyphen
- `[0-9]{4}` - exactly 4 digits

## Key Considerations

1. **Line Anchors**: Use `^` and `$` to ensure the entire line matches the pattern exactly
2. **Character Classes**: `[0-9]` matches any single digit
3. **Quantifiers**: `{n}` specifies exactly n occurrences
4. **Literal Characters**: Parentheses, spaces, and hyphens must be matched literally
5. **OR Logic**: Use `|` to match either format
6. **Escaping**: Some regex flavours require escaping certain characters

## Test Cases

### Edge Cases to Consider
- Lines with leading/trailing whitespace (shouldn't exist per problem statement)
- Empty lines
- Lines with partial matches
- Lines with valid patterns embedded in other text

### Additional Test Examples

**Input:**
```
(987) 654-3210
123-ABC-4567
(555) 123-4567
999-888-7777
(111) 222-3333 x456
```

**Expected Output:**
```
(987) 654-3210
(555) 123-4567
999-888-7777
```

## Bash Tools Available

- `grep` - pattern matching
- `awk` - text processing
- `sed` - stream editing
- `egrep` - extended regular expressions

 works as follows:

1. `^` - Start of line anchor
2. `(...)` - Grouping for alternation
3. `\([0-9]{3}\) ` - Format 1: literal `(`, 3 digits, literal `)`, space
4. `|` - OR operator
5. `[0-9]{3}-` - Format 2: 3 digits followed by hyphen
6. `[0-9]{3}-` - 3 digits followed by hyphen (common to both formats)
7. `[0-9]{4}` - 4 digits at the end
8. `# Valid Phone Numbers - LeetCode #193

## Problem Statement

Given a text file file.txt that contains a list of phone numbers (one per line), write a one-liner bash script to print all valid phone numbers. You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx.

## Valid Formats

**Format 1:** `(xxx) xxx-xxxx`
**Format 2:** `xxx-xxx-xxxx`

Where `x` represents a digit (0-9).

## Visual Pattern Breakdown

```
Format 1: (xxx) xxx-xxxx
          ╰──┬─╯ ╰─┬╯ ╰─┬─╯
             3    3    4
          digits digits digits

Format 2: xxx-xxx-xxxx
          ╰┬╯ ╰─┬╯ ╰─┬─╯
           3   3    4
        digits digits digits
```

## Example Input File (file.txt)

```
987-123-4567
123 456 7890
(123) 456-7890
555-555-55555
(555) 555-5555
123-456-789
(123)456-7890
(123) 456 7890
555.123.4567
phone: (555) 123-4567
+44 207 123 4567
1234567890
(123) 456-7890 ext 123
```

## Expected Output

```
987-123-4567
(123) 456-7890
(555) 555-5555
```

## Pattern Analysis

### Valid Examples
- `987-123-4567` ✅ (Format 2: xxx-xxx-xxxx)
- `(123) 456-7890` ✅ (Format 1: (xxx) xxx-xxxx)
- `(555) 555-5555` ✅ (Format 1: (xxx) xxx-xxxx)

### Invalid Examples
- `123 456 7890` ❌ (spaces instead of hyphens)
- `555-555-55555` ❌ (too many digits in last group)
- `123-456-789` ❌ (too few digits in last group)
- `(123)456-7890` ❌ (missing space after closing parenthesis)
- `(123) 456 7890` ❌ (space instead of hyphen in middle)
- `555.123.4567` ❌ (dots instead of hyphens)
- `phone: (555) 123-4567` ❌ (contains additional text)
- `+44 207 123 4567` ❌ (international format)
- `1234567890` ❌ (no formatting)
- `(123) 456-7890 ext 123` ❌ (contains extension)

## Regular Expression Components

### For Format 1: `(xxx) xxx-xxxx`
- `(` - literal opening parenthesis
- `[0-9]{3}` - exactly 3 digits
- `)` - literal closing parenthesis
- ` ` - single space
- `[0-9]{3}` - exactly 3 digits
- `-` - literal hyphen
- `[0-9]{4}` - exactly 4 digits

### For Format 2: `xxx-xxx-xxxx`
- `[0-9]{3}` - exactly 3 digits
- `-` - literal hyphen
- `[0-9]{3}` - exactly 3 digits
- `-` - literal hyphen
- `[0-9]{4}` - exactly 4 digits

## Key Considerations

1. **Line Anchors**: Use `^` and `$` to ensure the entire line matches the pattern exactly
2. **Character Classes**: `[0-9]` matches any single digit
3. **Quantifiers**: `{n}` specifies exactly n occurrences
4. **Literal Characters**: Parentheses, spaces, and hyphens must be matched literally
5. **OR Logic**: Use `|` to match either format
6. **Escaping**: Some regex flavours require escaping certain characters

## Test Cases

### Edge Cases to Consider
- Lines with leading/trailing whitespace (shouldn't exist per problem statement)
- Empty lines
- Lines with partial matches
- Lines with valid patterns embedded in other text

### Additional Test Examples

**Input:**
```
(987) 654-3210
123-ABC-4567
(555) 123-4567
999-888-7777
(111) 222-3333 x456
```

**Expected Output:**
```
(987) 654-3210
(555) 123-4567
999-888-7777
```

## Bash Tools Available

- `grep` - pattern matching
- `awk` - text processing
- `sed` - stream editing
- `egrep` - extended regular expressions

 - End of line anchor

### Why This Works

- The alternation `(\([0-9]{3}\) |[0-9]{3}-)` matches either:
  - `(xxx) ` - parentheses format with space
  - `xxx-` - hyphen format
- Both formats then continue with `[0-9]{3}-[0-9]{4}` (xxx-xxxx)
- Line anchors ensure exact matches only