/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        String toString = Integer.toString(x);
        String reversedString = new StringBuilder(toString).reverse().toString();
        try {
            return x < 0 ? Integer.parseInt(reversedString.substring(0, reversedString.length() - 1)) * -1
                    : Integer.parseInt(reversedString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
// @lc code=end

/*
 * My Approach:
 * 1. Convert the integer to string
 * 2. Reverse the string
 * 3. Convert the string to integer
 * 4. Return the integer
 */