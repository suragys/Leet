package com.leetcode.easy;/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

import java.util.HashMap;

public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        boolean odd = false;
        int maxLength = 0;
        // int[] characterFq = new int[26];
        // s = s.toLowerCase();
        HashMap<Character,Integer> chars = new HashMap();
        for(int i = 0; i < s.length(); i++){
            // characterFq[s.charAt(i) - 'a']++;
            if(chars.containsKey(s.charAt(i))){
                chars.put(s.charAt(i), chars.get(s.charAt(i))+1);
            } else {
                chars.put(s.charAt(i),1);
            }
        }  
        for(Character x: chars.keySet()){
            System.out.println(x + " : " + chars.get(x));
            if(chars.get(x)%2 == 0){
                maxLength += chars.get(x);
                 System.out.println(x + " : " + chars.get(x));
            } else {
                odd = true;
                maxLength += chars.get(x)-1;
            }
        }
        return maxLength + (odd == true ? 1:0);
    }
}
