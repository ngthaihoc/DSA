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


    public static int lengthOfLongestSubstring(String s) {
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


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
        if (s == null || s.length() == 0)
            return "";

        String sub = "";

        for (int temp = 0; temp < s.length(); temp++) {
            for (int i = temp; i < s.length(); i++) {
                boolean tempCheck = true;
                int left = temp;
                int right = i;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        tempCheck = false;
                        break;
                    }
                    left++;
                    right--;
                }

                if (tempCheck && (i - temp + 1 > sub.length())) {
                    sub = s.substring(temp, i + 1);
                }
            }
        }

        return sub;
    }



    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return  s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int curr = 0;
        Boolean goDown = false;
        for (int i = 0 ; i < s.length() ; i ++){
            rows[curr].append(s.charAt(i));
            if (curr == 0 || curr == numRows - 1){
                goDown = !goDown;
            }
            curr += goDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(rows[i]);
        }

        return result.toString();

    }


    public static int reverse(int x) {
        int res = 0, last;
        while (x != 0) {

            last = x % 10;

            x /= 10;

            if (Math.abs(res) > Integer.MAX_VALUE / 10) return 0;

            if (res == Integer.MAX_VALUE / 10 && last > 7) return 0;

            if (res == Integer.MIN_VALUE / 10 && last < -8) return 0;


            res = res * 10 + last;
        }
        return res;
    }


    public static int myAtoi(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        if (i == s.length() ) return 0;

        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+')
            i++;
        int result = 0;

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result = result * 10 + digit;

            i++;
        }

        return result * sign;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) { return false;}
        if (x == 0) {return true;}
        if (x % 10 == 0) { return false;}

        int reversed = 0;
        while (x > reversed)
        {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        return x == reversed || x == reversed / 10;
    }



    public static int maxArea(int[] height) {
        int start = 0, max = 0, end = height.length - 1;
        while (start < end) {
            int h = Math.min(height[start], height[end]);
            max = Math.max(max, h * (end - start));
            if (height[end] < height[start]) {
                end--;
            } else
                start++;
        }
        return max;
    }

}





