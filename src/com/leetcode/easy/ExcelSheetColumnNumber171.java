package com.leetcode.easy;

public class ExcelSheetColumnNumber171{
    public int titleToNumber(String s) {
        int x = 0;
        int b = 26;
        char r = 'A';
        for(int i = s.length()-1 ; i >= 0; i--){
            int p = (int)Math.pow(b,s.length()-i-1) ;
            int v = s.charAt(i)-r+1;
            x +=  p*v ;
        }
        return x;
    }
}
