package com.company;

import java.util.Stack;

public class DailyTemperatures {

    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] res = new int[T.length];
            Stack<Integer> stack = new Stack<>();

            for(int i=T.length-1; i>=0; i--){
                while(!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
                if(stack.isEmpty()) res[i] = 0;
                else res[i] = stack.peek()-i;
                stack.push(i);
            }

            return res;
        }
    }


}
