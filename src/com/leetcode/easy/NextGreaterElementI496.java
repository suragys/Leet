package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by surag on 2/22/17.
 * <p>
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 */
public class NextGreaterElementI496 {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        //   return bruteForce(findNums,nums);
        // Though the running time of the stack approach is O(n) is it because of the many comparisions that I am doing. Don't know exactly!!!!!!
        return stackbasedSolution(findNums, nums);
    }

    private int[] stackbasedSolution(int[] a, int[] b) {
        Stack<Integer> s = new Stack<Integer>();
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int n : b) {
            while (!s.isEmpty() && n > s.peek()) {
                m.put(s.pop(), n);
            }
            s.push(n);
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = m.getOrDefault(a[i], -1);
        }
        return a;
    }

    private int[] bruteForce(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            boolean found = false;
            int val = -1;
            for (int j = 0; j < b.length; j++) {
                if (b[j] == a[i]) found = true;
                if (found) {
                    if (b[j] > a[i]) {
                        val = b[j];
                        break;
                    }
                }
            }
            a[i] = val;
        }
        return a;
    }

    public static void main(String[] args) {
        NextGreaterElementI496 x = new NextGreaterElementI496();
    }
}
