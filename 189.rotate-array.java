/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // Brute force solution
        // Time complexity: O(n * k)
        // Space complexity: O(1)

        // for (int i = 0; i < k; i++) {
        // int temp = nums[nums.length - 1];
        // for (int j = nums.length - 1; j > 0; j--) {
        // nums[j] = nums[j - 1];
        // }
        // nums[0] = temp;
        // }

        // Optimal solution
        // Time complexity: O(n)
        // Space complexity: O(1)

        int n = nums.length;
        k = k % n; // Normalize k if it's greater than n

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining n -k elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// @lc code=end
