/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // Create a HashMap to store the characters and their indices
        Map<Character, Integer> map = new HashMap<>();
        
        // Initialize the start index and maximum length
        int start = 0, max = 0;
        
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // Check if the character is in the HashMap
            if (map.containsKey(s.charAt(i))) {
                // Update the start index to the maximum of the current start index and the index of the character in the HashMap
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            // Update the maximum length to the maximum of the current maximum length and the difference between the current index and the start index
            max = Math.max(max, i - start + 1);
            // Add the character and its index to the HashMap
            map.put(s.charAt(i), i);
        }
        // Return the maximum length
        return max;
    }
}
// @lc code=end

/*
 * Basic Idea:
 * 1. Create a HashMap to store the characters and their indices.
 * 2. Iterate through the string and check if the character is in the HashMap.
 * 3. If it is, update the start index to the maximum of the current start index and the index of the character in the HashMap.
 * 4. Update the maximum length to the maximum of the current maximum length and the difference between the current index and the start index.
 * 5. Add the character and its index to the HashMap.
 * 6. Return the maximum length.
 * 
 */

