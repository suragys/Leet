package com.leetcode.easy;

public class ReverseString344 {
    public String reverseString(String s) {
        char[] ar = s.toCharArray();
        int len = ar.length;
        for(int i = 0; i < len/2; i++){
            char t = ar[i];
            ar[i] = ar[len-1-i];
            ar[len-1-i] = t;
        }
        
        return new String(ar);
    }
}
