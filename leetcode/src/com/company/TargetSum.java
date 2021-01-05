package com.company;

public class TargetSum {

    class Solution {
        int res = 0;
        public int findTargetSumWays(int[] nums, int S) {

            DFS(nums, S, 0, 0);

            return res;
        }

        private void DFS(int[] nums, int s, int depth, int sum) {

            if(depth == nums.length){
                if(sum == s){
                    res++;
                }
                return;
            }

            DFS(nums, s, depth+1, sum+nums[depth]);
            DFS(nums, s, depth+1, sum-nums[depth]);
        }
    }
}
