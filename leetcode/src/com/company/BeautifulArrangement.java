package com.company;

public class BeautifulArrangement {

    class Solution {
        int res;
        boolean[] visitied;
        public int countArrangement(int n) {
            visitied = new boolean[n+1];
            DFS(n, 1, new int[n+1]);
            return res;
        }

        private void DFS(int n, int depth, int[] arr) {
            if(depth == n+1){
                res++;
                return;
            }

            for(int i=1; i<=n; i++){
                if(visitied[i]) continue;
                if(depth % i != 0 || i % depth != 0) continue;
                visitied[i] = true;
                arr[depth] = i;
                DFS(n, depth+1, arr);
                visitied[i] = false;
            }
        }

    }

}
