package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by surag on 1/20/17.
 * <p>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedinanArray448 {
    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindAllNumbersDisappearedinanArray448 o = new FindAllNumbersDisappearedinanArray448();
        List<Integer> ans = o.findDisappearedNumbers(nums);
        System.out.println(ans.toString());

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
//        ArrayList<Integer> d = new ArrayList<Integer>(Collections.nCopies(nums.length, 0));
//        for(int i = 0; i < nums.length; i++) {
//            d.set(nums[i] -1, nums[i]);
//        }
//
//        for(int i = 0; i < d.size(); i++) {
//            if(d.get(i) == i+1){
//                d.set(i, -1);
//            } else {
//                d.set(i, i+1);
//            }
//        }
//
//        Iterator i = d.iterator();
//        while(i.hasNext()){
//            if((int)i.next() == -1){
//                i.remove();
//            }
//        }
//
//        return d;

        List<Integer> d = new ArrayList<Integer>();
//
//        for(int i =0; i < nums.length; i++) {
//            while(nums[i] != nums[nums[i] - 1]) {
//                // swap the i th term to its place
//                int temp = nums[i];
//                nums[i] = nums[nums[i] - 1];
//                nums[temp - 1] = temp;
//            }
//        }
//
//        int i = 0;
//        while(i < nums.length) {
//            if(nums[i] != i +1){
//                d.add(i+1);
//            }
//            i++;
//        }
//
//        return d;


        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                d.add(i + 1);
            }
        }

        return d;
    }
}
