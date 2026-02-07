package com.fpt.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String s = "pwwkew";
        int length = s.length();
        int l = 0;
        int r = 0;
        if (length < 2) return;

        while ( l < length -1 ){
             r = l + 1 ;
            if (s.substring(l, l + 1).equals(s.substring(r, r + 1))) {
                System.out.println(" " + l + " và " + r);
            }
            l++;
        }

    }
}

