/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start

/*
 * Definition for singly-linked list.
 * file related to: ListNode.java
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head to simplify adding nodes
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        // Loop until both lists are exhausted and there is no carry left
        while (p != null || q != null || carry != 0) {
            int sum = carry;

            // Add the values of l1 and l2 nodes if they exist
            if (p != null) {
                sum += p.val;
                p = p.next;
            }
            if (q != null) {
                sum += q.val;
                q = q.next;
            }

            // Update carry for the next iteration
            carry = sum / 10;

            // Add the digit to the new list
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        // The result list is in dummyHead.next
        return dummyHead.next;
    }
}
// @lc code=end
