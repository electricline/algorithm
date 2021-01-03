package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString {

    class Solution {
        public String decodeString(String s) {

            Deque<Integer> nums = new ArrayDeque<>();
            Deque<StringBuilder> result = new ArrayDeque<>();
            result.push(new StringBuilder());


            for(int i=0; i<s.length(); i++){

                char ch = s.charAt(i);

                if(Character.isDigit(ch)){
                    int start = i;
                    while(Character.isDigit(s.charAt(i+1))) i++;
                    nums.push(Integer.valueOf(s.substring(start, i+1)));
                } else if(ch == '['){
                    result.push(new StringBuilder());
                } else if(ch == ']'){
                    StringBuilder str = result.pop();
                    int times = nums.pop();
                    StringBuilder sb = new StringBuilder();
                    for(int j=0; j<times; j++){
                        sb.append(str);
                    }
                    result.push(result.pop().append(sb));
                } else {
                    result.push(result.pop().append(ch));
                }

            }
            return result.pop().toString();
        }
    }

}
