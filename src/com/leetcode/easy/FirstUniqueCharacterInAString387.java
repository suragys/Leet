package com.leetcode.easy;

public class FirstUniqueCharacterInAString387 {
    public int firstUniqChar(String s) {
       int[] c = new int[26];
       char b = 'a';
       char[] in = s.toCharArray();
       
       for(int i = 0; i < in.length; i++){
           c[in[i]-b]++;
       }
       
       for(int i=0; i < in.length; i++){
           if(c[in[i]-b] == 1)return i;
       }
       return -1;
    }
}
