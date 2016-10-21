package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.
For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
*/
public class BinaryWatch401 {
    public List<String> readBinaryWatch(int num) {
            // Total number of LEDs are 10 = 4(hours) 6(minutes)
            // hours: 0 - 11 : 0000 - 1011 ; 12(1100) 13(1101) 14(1110) 15(11111) are not valid
            // minutes : 00 - 59 ; max=111111=63 111110=62 111101=61 111100=60 are invalid

            // if num < 5 then we can
            List<Integer> h ;
            List<Integer> m ;
            List<String> times = new ArrayList<String>();
            for(int i = 0; i < (int)Math.pow(2,10); i++){
                int temp = i;
                h = new ArrayList<Integer>();
                m = new ArrayList<Integer>();
                if(numberOfOnes(i) == num) {
                    System.out.print(Integer.toBinaryString(temp));
                    for (int j = 0; j < 10; j++) {
                        int x = temp & 1;
//                        System.out.print(x);
                        temp = temp >> 1;
                        if(x == 1) {
                            if (j < 6) {
                                m.add(j);
                            } else {
                                h.add(j-6);
                            }
                        }
                    }
                    String time = computeTime(h,m);
                    if(time != null){
                        times.add(time);    
                    }
                    System.out.println();
                }
            }
            return  times;
        }

        private static int numberOfOnes(int val){
            int count = 0;
            // we are sure that number cannot be bigger than 10 bits
            for(int i = 0; i< 10; i++) {
                count += val & 1;
                val = val >> 1;
            }
            return count;
        }
        private static String computeTime(List<Integer> h, List<Integer> m){
//            String time = "";
            
            System.out.print("\t h = " + h.toString());
            System.out.print("\t m = "  + m.toString());

            StringBuffer time = new StringBuffer();
            int hour = getDecimalVal(h);
            int min = getDecimalVal(m);
            if(hour > 11 || min > 59){
                return null;
            }
            time.append(convertToString(getDecimalVal(h),1));
            time.append(":");
            time.append(convertToString(getDecimalVal(m),2));

            return time.toString();
        }

        private static int getDecimalVal(List<Integer> ls){
            int val =0;
            for (Integer i : ls) {
                val += (int)Math.pow(2,i);
            }
            return val;
        }

        private static String convertToString(int n,int length){
            StringBuffer time = new StringBuffer();
            while(n > 0){
                int val = n%10;
                n = n/10;
                time.insert(0,val);
            }
            if(time.length()<length){
                int i = time.length();
                while(i < length){
                    time.insert(0,"0");
                    i++;
                }
            }
            return time.toString();
        }

}
