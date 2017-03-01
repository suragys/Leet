package com.leetcode.medium;

/**
 * Created by Surag on 2/28/17.
 * <p>
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * <p>
 * Example:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class ArithmeticSlices413 {

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        return bruteForce(A);
    }

    private int bruteForce(int[] A) {
        int[] diffArr = new int[A.length - 1];

        for (int i = 0; i < diffArr.length; i++) {
            diffArr[i] = A[i + 1] - A[i];
        }
        int numOfSlices = 0;
        int i = 0;
        while (i < diffArr.length - 1) {
            int j = i;
            while (j < diffArr.length - 1 && diffArr[j] == diffArr[j + 1]) {
                j++;
            }
            if (j - i >= 1) {
                int contArrSize = j - i + 2;
                double n = contArrSize - 2;
                numOfSlices += (int) ((n + 1) * (n) / 2);
            }
            i = j + 1;
        }
        return numOfSlices;
    }
}
