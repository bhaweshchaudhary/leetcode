/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        // Brute force solution
        // Time complexity: O(n^3)
        // Space complexity: O(1)

        // int n = s.length();
        // String result = "";
        // for (int i = 0; i < n; i++) {
        // for (int j = i + 1; j <= n; j++) {
        // String sub = s.substring(i, j);
        // if (isPalindrome(sub) && sub.length() > result.length()) {
        // result = sub;
        // }
        // }
        // }
        // return result;

        // Optimal solution
        // Time complexity: O(n^2)
        // Space complexity: O(1)

        int n = s.length();
        String result = "";
        for (int i = 0; i < n; i++) {
            String odd = expandAroundCenter(s, i, i);
            String even = expandAroundCenter(s, i, i + 1);
            if (odd.length() > result.length()) {
                result = odd;
            }
            if (even.length() > result.length()) {
                result = even;
            }
        }
        return result;
    }

    private String expandAroundCenter(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
// @lc code=end

