package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {

    class Solution {
        boolean[][] visitied;
        int res = 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        public int numIslands(char[][] grid) {
            visitied = new boolean[grid.length][grid[0].length];

            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(!visitied[i][j] && grid[i][j] == '1'){
                        bfs(i,j, grid);
                        res++;
                    }
                }
            }

            return res;
        }

        private void bfs(int i, int j, char[][] grid) {

            Queue<Integer> q = new LinkedList();
            q.add(i); q.add(j);
            visitied[i][j] = true;

            while(!q.isEmpty()){

                int cur_r = q.poll(); int cur_c = q.poll();
                for(int dir=0; dir<4; dir++){
                    int nr = cur_r + dr[dir];
                    int nc = cur_c + dc[dir];

                    if(nr < 0 || nr >= visitied.length || nc < 0 || nc >= visitied[0].length) continue;
                    if(visitied[nr][nc] || grid[nr][nc] == '0') continue;
                    q.add(nr); q.add(nc);
                    visitied[nr][nc] = true;
                }
            }

        }
    }
}
