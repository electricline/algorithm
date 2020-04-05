package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class gymclothes {
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = n-lost.length;
            int count = 0;

            for(int i=0; i<lost.length; i++){
                for(int j=0; j<reserve.length; j++){
                    if(reserve[j] == lost[i]){
                        reserve[j] = -1;
                        lost[i] = -1;
                        count++;
                        break;
                    }
                }
            }

            for(int i=0; i<lost.length; i++){
                for(int j=0; j<reserve.length; j++){
                    if(reserve[j] == lost[i]-1) {
                        reserve[j] = -1;
                        count++;
                        break;
                    } else if (reserve[j] == lost[i]+1) {
                        reserve[j] = -1;
                        count++;
                        break;
                    }
                }

            }
            answer += count;

            return answer;
        }
    }
}
