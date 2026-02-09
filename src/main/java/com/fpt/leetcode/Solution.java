package com.fpt.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//        ListNode dumHead = new ListNode(0);
//        ListNode curr = dumHead;
//        int carry = 0;
//
//        while (l1 != null || l2 != null || carry > 0){
//
//            int x = (l1 != null) ? l1.val : 0;
//            int y = (l2 != null) ? l2.val : 0;
//
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//
//            if (l1 != null) l1 = l1.next;
//            if (l2 != null) l2 = l2.next;
//        }
//
//        return dumHead.next;
//    }


    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxlong = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            maxlong = Math.max(maxlong, r - l + 1);
        }

        return maxlong;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] arr = new double[nums1.length + nums2.length];
        int j = 0;

        for (int i : nums1) arr[j++] = i;
        for (int i : nums2) arr[j++] = i;

        Arrays.sort(arr);

        if (arr.length % 2 == 0)
        {
            return (arr [ arr.length / 2 ] + arr[ arr.length / 2 - 1 ]) / 2;
        }
        else return arr[ arr.length / 2 ];
    }


    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        String sub = "";
        int temp = 0;
        while (temp < arr.length) {

            for (int i = temp + 1; i < s.length(); i++) {
                if (arr[temp] == arr[i] && arr[temp + 1] == arr[i - 1]) {
                    sub = s.substring(temp, i + 1);
                }
            }

            temp++;
        }
        return sub;
    }

}
