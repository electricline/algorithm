package com.company;

public class MaximumPointsYouCanObtainfromCards {

    class Solution {
        public int maxScore(int[] cardPoints, int k) {

            int result = 0;
            for(int i=cardPoints.length-1; i>cardPoints.length-1-k; i--){
                result += cardPoints[i];
            }

            int maxScore = result;

            for(int i=1; i<=k; i++){
                result = result + cardPoints[i - 1] - cardPoints[cardPoints.length - k + i - 1];
                maxScore = Math.max(maxScore, result);
            }

            return maxScore;
        }
    }
}
