package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pacificAtlantic(new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
    }

    static class Solution {
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        boolean[][] check;
        boolean[][] visitied;
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {

            check = new boolean[matrix.length][matrix[0].length];

            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    if(check[i][j]) continue;
                    searchPacific(matrix, i, j, check);
                }
            }

            List<List<Integer>> res = new ArrayList<>();

            for(int i=0; i<check.length; i++){
                for(int j=0; j<check[0].length; j++){
                    if(!check[i][j]) continue;
                    List<Integer> list = new ArrayList<>();
                    list.add(i); list.add(j);
                    res.add(list);
                }
            }

            return res;
        }

        private void searchPacific(int[][] matrix, int row, int col, boolean[][] check) {
            visitied = new boolean[matrix.length][matrix[0].length];
            Queue<pair> q = new LinkedList<>();
            q.add(new pair(row,col));
            visitied[row][col] = true;
            boolean pacificVisitied = false, atlanticVisitied = false;
            while(!q.isEmpty()){

                pair cur = q.poll();

                if(pacificVisitied && atlanticVisitied){
                    for(int i=0; i<check.length; i++){
                        for(int j=0; j<check[0].length; j++){
                            if(!visitied[i][j]) continue;
                            if(check[i][j]) continue;
                            check[i][j] = visitied[i][j];
                        }
                    }
                    return;
                }

                if(cur.r == 0 || cur.c == 0) pacificVisitied = true;
                if(cur.r == matrix[0].length || cur.c == matrix.length) atlanticVisitied = true;


                for(int dir=0; dir<4; dir++){
                    int nr = cur.r + dy[dir];
                    int nc = cur.c + dx[dir];

                    if(nr < 0 || nr >= matrix.length || nc < 0 || nc >= matrix[0].length) continue;
                    if(visitied[nr][nc]) continue;
                    if(matrix[cur.r][cur.c] < matrix[nr][nc]) continue;
                    q.add(new pair(nr,nc));
                    visitied[nr][nc] = true;
                }

            }

        }
    }

    static class pair {
        int r;
        int c;

        pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

}
