package com.leetcode.easy;

public class MoveZeroes {
   
    public void moveZeroes(int[] nums) {
        // int j = 0;
        // int c = 0;
        // while(j < nums.length){
        //     if(nums[j] == 0){
        //          c++;
        //          j++;
        //          while(j < nums.length && nums[j] == 0){
        //             c++;
        //             j++; 
        //          }
        //          if(j == nums.length){
        //                 break;
        //             }
        //     }
        //      if(c > 0){
        //         nums[j-c] = nums[j];
        //     }
        //     j++;
        // }
        // for(int i = 0; i < c; i++ ){
        //     nums[j-1-i] = 0;
        // }
    
    
        int l = 0;
        int r = 0;
        while( r < nums.length && nums[r] != 0){
            r++;
        }
        l = r+1;
        while(l < nums.length){
            if(nums[l] != 0){
                nums[r] = nums[l];
                nums[l] = 0;
                r++;
            }
        l++;
        }
    }
}
