package com.leetcode.easy;

/**
 * Created by surag on 1/21/17.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion6 {
    public static void main(String[] args) {

        System.out.println(new ZigZagConversion6().convert("A", 2  ));

    }

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuffer sb =  new StringBuffer();
        int val = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++) {
            int x = i;
            boolean B = true;
            int T = val - 2 * i;
            int F = 2 * i;
            while(x < s.length()) {
                if(i == 0 || i == numRows - 1) {
                    sb.append(s.charAt(x));
                    System.out.println(x + " " + s.charAt(x));
                    x += val;
                } else {
                    if(B) {
                        sb.append(s.charAt(x));
                        System.out.println(x + " " + s.charAt(x));
                        x += T;
                        B = !B;
                    } else {
                        sb.append(s.charAt(x));
                        System.out.println(x + " " + s.charAt(x));
                        x += F;
                        B = !B;
                    }
                }
            }
        }
        return sb.toString();
    }
}
