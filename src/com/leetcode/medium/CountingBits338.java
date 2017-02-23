package com.leetcode.medium;

/**
 * Created by surag on 2/22/17.
 * <p>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 */
public class CountingBits338 {
    public int[] countBits(int num) {
        // return bruteForce(num);
        return pattern(num);
    }

    private int[] pattern(int n) {
        if (n < 2) {
            if (n == 0) return new int[1];
            if (n == 1) {
                return new int[]{0, 1};
            }
        }

        // using Array list effects of the performance.
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        int resSize = 2;
        while (resSize <= n) {
            int s = resSize;
            for (int i = 0; i < s && resSize <= n; i++) {
                int x = res[i];
                res[i + s] = x + 1;
                resSize++;
            }
        }
        return res;
    }

    private int[] bruteForce(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int temp = i;
            int numOfOnes = 0;
            while (temp > 0) {
                int x = temp & 1;
                if (x == 1) {
                    numOfOnes++;
                }
                temp = temp >> 1;
            }
            res[i] = numOfOnes;
        }
        return res;
    }
}
