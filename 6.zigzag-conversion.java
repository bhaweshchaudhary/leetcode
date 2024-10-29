/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        // Time complexity: O(n)
        // Space complexity: O(n)
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int n = s.length();
        int i = 0;
        while (i < n) {
            for (int j = 0; j < numRows && i < n; j++) {
                rows[j].append(s.charAt(i++));
            }
            for (int j = numRows - 2; j > 0 && i < n; j--) {
                rows[j].append(s.charAt(i++));
            }
        }
        for (int j = 1; j < numRows; j++) {
            rows[0].append(rows[j]);
        }
        return rows[0].toString();
    }
}
// @lc code=end

