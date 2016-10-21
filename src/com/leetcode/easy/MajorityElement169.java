package com.leetcode.easy;

import java.util.Arrays;

public class MajorityElement169 {
    public int majorityElement(int[] num) {
        Arrays.sort(num);
        return num[num.length/2];
        
        //     int major=num[0], count = 1;
        // for(int i=1; i<num.length;i++){
        //     if(count==0){
        //         count++;
        //         major=num[i];
        //     }else if(major==num[i]){
        //         count++;
        //     }else count--;
            
        // }
        // return major;
    
    }
}
