package com.company;

public class carpet {
    static class Solution {
        public int[] solution(int brown, int red) {
            int[] answer = new int[2];

            int num = brown + red;
            int b = 0;
            for(int i=1; i<=num; i++){
                if(num % i == 0 ){
                    b = (brown+4)/2 - i;
                    if(brown + red == i*b){
                        answer[0] = i;
                        answer[1] = b;
                    }
                }
            }

            return answer;
        }
    }
}
