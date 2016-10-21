package com.leetcode.easy;

public class PowerOfThree326 {
    public boolean isPowerOfThree(int n) {

        // while(n%3 == 0){
        //     n = n/3;
        // }
        // return n==1;
        int max = 1162261467; // 3^19
        
        return n > 0 && max % n ==0;
    }
}
