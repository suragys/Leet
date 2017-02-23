package com.leetcode.easy;

import static org.junit.Assert.*;

/**
 * Created by surag on 1/22/17.
 */
public class MinimumMovestoEqualArrayElements453Test {
    @org.junit.Test
    public void minMoves() throws Exception {
        int[] a = {1,2,3};
        int ans = 3;
        int result = new MinimumMovestoEqualArrayElements453().minMoves(a);
        assertTrue(result == ans);
    }

    @org.junit.Test
    public void minMoves2() throws Exception {
        int[] a = {1,2,3};
        int ans = 4;
        int result = new MinimumMovestoEqualArrayElements453().minMoves(a);
        assertTrue(result == ans);
    }

    @org.junit.Test
    public void minMoves3() throws Exception {
        int[] a = {1,2,3};
        int ans = 3;
        int result = new MinimumMovestoEqualArrayElements453().minMoves(a);
        assertTrue(result == ans);
    }



}