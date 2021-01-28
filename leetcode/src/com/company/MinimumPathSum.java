package com.company;

public class MinimumPathSum {

    class Solution {
        public int minPathSum(int[][] grid) {

            int r = grid.length;
            int c = grid[0].length;
            return getMinByDP(grid, r-1, c-1);
        }

        private int getMinByDP(int[][] grid, int r, int c){

            for(int i=0; i<=r; i++){
                for(int j=0; j<=c; j++){
                    if(i == 0 && j ==0) grid[i][j] = grid[i][j];
                    else if(i == 0 && j != 0) grid[i][j] = grid[i][j] + grid[i][j-1];
                    else if(j == 0 && i != 0) grid[i][j] = grid[i][j] + grid[i-1][j];
                    else grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }

            return grid[r][c];
        }

        private int getMinByRecursion(int[][] grid, int r, int c) {

            if(r == 0 && c == 0) return grid[r][c];
            if(r == 0) return grid[r][c] + getMinByRecursion(grid, r, c-1);
            if(c == 0) return grid[r][c] + getMinByRecursion(grid,r-1, c);
            return grid[r][c] + Math.min(getMinByRecursion(grid,r-1,c), getMinByRecursion(grid,r,c-1));

        }
    }
}
