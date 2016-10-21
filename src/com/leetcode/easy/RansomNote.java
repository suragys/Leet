package com.leetcode.easy;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) return false;
        int[] c = new int[26];
        for(int i =0; i < magazine.length(); i++){
             c[magazine.charAt(i)-'a']++;
             if(i < ransomNote.length()){
                 c[ransomNote.charAt(i)-'a']--;
             }
        }
        for(int i =0; i < c.length; i++){
            if(c[i] < 0){
                return false;
            }
        }
        return true;
    }
}
