package com.leetcode.easy;

/**
 * Created by surag on 1/22/17.
 * <p>
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinimumMovestoEqualArrayElements453 {
    public int minMoves(int[] nums) {
//         int min = Integer.MAX_VALUE;
//        for (int num : nums) {
//            if (num < min) {
//                min = num;
//            }
//        }
//         int count = 0;
//        for (int num : nums) {
//            count += (num - min);
//        }

        // return count;

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            sum += num;
        }

        return sum - (min * nums.length);
    }

}
