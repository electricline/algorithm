package com.company;

import java.util.Stack;

public class ironbar {
    static class Solution {
        public int solution(String arrangement) {
            int answer = 0;

            Stack stack = new Stack();

            String newArrangement = arrangement.replace("()", "0");

            for(int i=0; i<newArrangement.length(); i++){
                if(newArrangement.charAt(i) == '('){
                    stack.add(newArrangement.charAt(i));
                } else if(newArrangement.charAt(i) == '0'){
                    answer += stack.size();
                } else if(newArrangement.charAt(i) == ')'){
                    stack.pop();
                    answer+=1;
                }
            }


            return answer;
        }
    }
}
