package com.company;

public class ClimbingStairs {

    class Solution {
        public int climbStairs(int n) {
            if( n== 1)
                return 1;

            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;

            for(int i=3; i<=n; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
//            return recursion(0, n);
        }

        private int recursion(int start, int n){
            if(start > n){
                return 0;
            }
            if(start == n){
                return 1;
            }
            return recursion(start +1, n) + recursion(start+2, n);
        }

    }
}
