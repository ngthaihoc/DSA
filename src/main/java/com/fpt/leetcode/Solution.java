package com.fpt.leetcode;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }

        return new int[] {};
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dumHead = new ListNode(0);
        ListNode curr = dumHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0){

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dumHead.next;
    }
}
