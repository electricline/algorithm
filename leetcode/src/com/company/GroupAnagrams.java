package com.company;

import java.util.*;

public class GroupAnagrams {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            findAnagrams(strs, res);
            return res;
        }

        private void findAnagrams(String[] strs, List<List<String>> res) {

            Map<String, List> ans = new HashMap<>();

            for(String s : strs){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key  = String.valueOf(chars);
                if(!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }

            for(String key : ans.keySet()){
                res.add(ans.get(key));
            }
        }

    }

}
