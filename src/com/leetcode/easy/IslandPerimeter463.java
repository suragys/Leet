package com.leetcode.easy;

/**
 * Created by surag on 1/19/17.
 */
public class IslandPerimeter463 {
    private static int P =  0;
    public static void main(String[] args) {
//        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int[][] grid = {{1}};
        System.out.println(new IslandPerimeter463().islandPerimeter(grid));

    }

    public int islandPerimeter(int[][] grid) {
//        int[][] peri = new int[grid.length][grid[0].length];
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//
//                if (grid[i][j] == 1) {
//                    peri[i][j] = 4;
//                }
//            }
//        }
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] > 0) {
//                    // check 4 cells [i - 1][j], [i + 1][j], [i][j-1], [i][j+1]
//                    //case 1 [i - 1][j]
//                    // System.out.println("i =" + i + " j=" + j);
//                    if (i > 0 && i < grid.length) {
//                        if (grid[i - 1][j] == 1) {
//                            peri[i][j]--;
//                        }
//                    }
//                    if (i < grid.length - 1 && i >= 0) {
//                        if (grid[i + 1][j] == 1) {
//                            peri[i][j]--;
//                        }
//                    }
//                    if (j > 0 && j < grid[0].length) {
//                        if (grid[i][j - 1] == 1) {
//                            peri[i][j]--;
//                        }
//                    }
//                    if (j < grid[0].length - 1 && j >= 0) {
//                        if (grid[i][j + 1] == 1) {
//                            peri[i][j]--;
//                        }
//                    }
//                }
//
//            }
//        }
//        int p = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (peri[i][j] > 0) {
//                    p += peri[i][j];
//                }
//            }
//        }
//
//        return p;
//        int p = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if(grid[i][j] == 1) {
//                    if(i == 0 || grid[i-1][j] == 0){
//                        p++;
//                    }
//                    if(i == grid.length -1 || grid[i+1][j] == 0) {
//                        p++;
//                    }
//                    if(j == 0 || grid[i][j-1] == 0){
//                        p++;
//                    }
//                    if(j == grid[0].length -1 || grid[i][j+1] == 0) {
//                        p++;
//                    }
//
//                }
//            }
//        }

//        int islands = 0;
//        int neighbors = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    islands++;
//                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbors++;
//                    if (j < grid[0].length - 1 && grid[i][j+1] == 1) neighbors++;
//                }
//            }
//        }
//        return (4 * islands) - (2 * neighbors);

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return P;
                }
            }
        }
        return 0;
    }
    public void dfs(int[][]grid, int i, int j) {
        if(i < 0 || i > grid.length -1 || j < 0 || j > grid[0].length - 1 || grid[i][j] != 1){
            return;
        }
        grid[i][j] = -1;
        if( i == 0 || grid[i-1][j] == 0) P++;
        if( i == grid.length -1 || grid[i+1][j] == 0) P++;
        if( j == 0 || grid[i][j-1] == 0) P++;
        if( j == grid[0].length -1 || grid[i][j+1] == 0) P++;

        dfs(grid,i - 1 ,j);
        dfs(grid,i + 1 ,j);
        dfs(grid,i ,j - 1);
        dfs(grid,i ,j + 1);
    }

}
