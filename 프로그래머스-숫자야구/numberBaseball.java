package com.company;

public class numberBaseball {
    static class Solution {
        public int solution(int[][] baseball) {
            int answer = 0;
            String number = "";
            String temp = "";
            boolean flag;
            for(int i=100; i<1000; i++){
                temp = String.valueOf(i);

                if(temp.charAt(0) == temp.charAt(1) || temp.charAt(0) == temp.charAt(2) || temp.charAt(1) == temp.charAt(2))
                    continue;
                else if(temp.charAt(0) == '0' || temp.charAt(1) == '0' || temp.charAt(2) == '0')
                    continue;
                flag = true;

                for(int j=0; j < baseball.length; j++){
                    int strike = 0;
                    int ball = 0;

                    for(int k=0; k<3; k++){
                        for(int m = 0; m<3; m++){
                            number = String.valueOf(baseball[j][0]);

                            if( k == m && temp.charAt(k) == number.charAt(m)){
                                strike++;
                                continue;
                            }

                            if( k != m && temp.charAt(k) == number.charAt(m)){
                                ball++;
                                continue;
                            }
                        }
                    }


                    if(strike != baseball[j][1] || ball != baseball[j][2]){
                        flag = false;
                        break;
                    }

                }
                if(flag == true){
                    answer++;
                }
            }
            return answer;
        }
    }
}
