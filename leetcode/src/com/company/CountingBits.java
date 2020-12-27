package com.company;

public class CountingBits {

    class Solution {
        public int[] countBits(int num) {

            int[] dp = new int[num+1];
            dp[0] = 0;
            int pow = 1;
            for(int i=1, t=0; i<=num; i++, t++){
                if(i == pow){
                    pow *= 2;
                    t=0;
                }
                dp[i] = dp[t] + 1;
            }
            return dp;
        }
    }
}
