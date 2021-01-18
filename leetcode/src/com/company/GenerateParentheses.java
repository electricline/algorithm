package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    class Solution {
        List<String> res = new ArrayList<>();
        public List<String> generateParenthesis(int n) {

            backtracking(2*n, 0, new ArrayList());

            return res;
        }

        private void backtracking(int n, int depth, List<Character> list) {
            if(n == depth){
                if(validParentthesis(list)){
                    StringBuilder sb = new StringBuilder();
                    for(int i=0; i<list.size(); i++){
                        sb.append(list.get(i));
                    }
                    res.add(sb.toString());
                }
                return;
            }

            for(int i=0; i<2; i++){
                if(i%2 == 0)
                    list.add('(');
                else
                    list.add(')');
                backtracking(n, depth+1, list);
                if(i%2 == 0)
                    list.remove(list.size()-1);
                else
                    list.remove(list.size()-1);
            }
        }

        private boolean validParentthesis(List<Character> list) {
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<list.size(); i++){
                if(list.get(i) == '(')
                    stack.add(list.get(i));
                else {
                    if(stack.isEmpty())
                        return false;
                    else {
                        if(stack.peek() == ')')
                            return false;
                        else
                            stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()) return false;
            return true;
        }
    }
}
