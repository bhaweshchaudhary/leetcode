/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // Create a HashMap to store the difference between target and current number and its index
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the current number is in the HashMap
            if (map.containsKey(nums[i])) {
                // If it is, return the indices of the current number and the number in the HashMap
                return new int[] { map.get(nums[i]), i };
            } else {
                // If it is not, add the difference and its index to the HashMap
                map.put(target - nums[i], i);
            }
        }
        // Return an empty array if no solution is found
        return new int[] {};

    }
}
// @lc code=end

/*
 * Basic Idea:
 * 1. Create a HashMap to store the difference between target and current number and its index.
 * 2. Iterate through the array and check if the current number is in the HashMap.
 * 3. If it is, return the indices of the current number and the number in the HashMap.
 * 4. If it is not, add the difference and its index to the HashMap.
 * 
 */