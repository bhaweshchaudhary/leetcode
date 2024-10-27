/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int maxLeftX = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRightX = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int maxLeftY = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRightY = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }
}
// @lc code=end

/*
 * Approach:
 * 1. Use binary search on the smaller array to partition both arrays into two
 * halves.
 * 2. Ensure that all elements on the left side are less than or equal to those
 * on the right side.
 * 3. Adjust the partition based on conditions to find the correct split.
 * 4. Calculate the median:
 * - If the total length is odd, return the max of the left side.
 * - If even, return the average of the max of the left side and min of the
 * right side.
 */
