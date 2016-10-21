package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //return intersectWithMaps(nums1,nums2);
        //return intersectionWithSorting(nums1,nums2);
        return intersectionWithSortingWithoutCollections(nums1,nums2);
    }
    public static int[] intersectionWithSortingWithoutCollections(int[] nums1, int[] nums2){
        if(nums1.length == 0) return new int[0];
        if(nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0;
        int j =0;
        int k =0;
        int[] r = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                r[k] = nums1[i];
                i++;
                j++;
                k++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else {
                i++;
            }
        }

        return Arrays.copyOfRange(r, 0, k);
    }
    
    public static int[] intersectionWithSorting(int[] nums1, int[] nums2){
        if(nums1.length == 0) return new int[0];
        if(nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0;
        int j =0;
        ArrayList<Integer> r = new ArrayList<Integer>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                r.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else {
                i++;
            }
        }
        int[] res = new int[r.size()];
        for(int k = 0; k < res.length; k++){
            res[k] = r.get(k);
        }
        return res;
    }
    
    public static int[] interesctWithMaps(int[] nums1,int[] nums2){
        if(nums1.length == 0) return new int[0];
        if(nums2.length == 0) return new int[0];
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0; i<nums1.length; i++){
            if(m.containsKey(nums1[i])){
                m.put(nums1[i],m.get(nums1[i])+1);
            } else{
                m.put(nums1[i],1);
            }
        }
        ArrayList<Integer> r = new ArrayList<Integer>();
        for(int i=0; i<nums2.length; i++){
            if(m.containsKey(nums2[i])){
                int c = m.get(nums2[i]);
                if(c > 0) r.add(nums2[i]);
                
                if(--c == 0){
                    m.remove(nums2[i]);
                }else {
                    m.put(nums2[i], c);
                }
            }
        }
        int[] res = new int[r.size()];
        for(int i=0; i<r.size(); i++){
            res[i] = r.get(i);
        }
        return res;
    }
    
}
