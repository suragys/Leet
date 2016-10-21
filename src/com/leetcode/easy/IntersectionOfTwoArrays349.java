package com.leetcode.easy;

import java.util.HashMap;

public class IntersectionOfTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Boolean> m = new HashMap<Integer,Boolean>();
        if(nums1.length == 0) return nums1;
        if(nums2.length == 0) return nums2;
        if(nums2.length > nums1.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
            for(int i = 0; i < nums2.length;i++){
                m.put(nums2[i],Boolean.FALSE);
            }
            int c=0;
            for(int i = 0; i< nums1.length;i++){
                if(m.containsKey(nums1[i])){
                   if(!m.get(nums1[i])) c++;
                   m.put(nums1[i],Boolean.TRUE);
                }
            }
            int[] res = new int[c];
            int i = 0;
            for(Integer x : m.keySet()){
                if(m.get(x)){
                    res[i++] = x;    
                }
            }
       return res;
    }
}
