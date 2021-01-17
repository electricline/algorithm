package com.company;

import java.util.*;

public class CombinationSum {

    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            DFS(candidates, target, 0, new ArrayList<>(), 0);
            return res;
        }

        private void DFS(int[] candidates, int target, int sum, List<Integer> list, int start) {
            if(sum > target) return;
            if(sum == target) {
                List<Integer> temp = new ArrayList<>();
                for(int i=0; i<list.size(); i++){
                    temp.add(list.get(i));
                }
                res.add(temp);
                return;
            }

            for(int i=start; i<candidates.length; i++){
                if(candidates[i] + sum > target) continue;
                list.add(candidates[i]);
                DFS(candidates, target, sum+candidates[i], list, i);
                list.remove(list.size()-1);
            }
        }
    }

}
