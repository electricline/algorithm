package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartionLabels3 {

    class Solution {
        public List<Integer> partitionLabels(String S) {
            List<Integer> list = new ArrayList<>();

            Map<Character, Integer> map = new HashMap<>();

            // counting
            for(int i=0; i<S.length(); i++){
                map.put(S.charAt(i), map.getOrDefault(S.charAt(i),0) + 1);
            }

            int start = 0, end = 0;
            Map<Character, Integer> tempMap = new HashMap<>();

            while(end < S.length()){
                char c = S.charAt(end);

                if(!tempMap.containsKey(c)){
                    tempMap.put(c, map.get(c));
                }

                tempMap.put(c, tempMap.get(c) - 1);

                if(tempMap.get(c) == 0){
                    tempMap.remove(c);
                }

                if(tempMap.keySet().size() == 0){
                    list.add(end - start + 1);
                    start = end + 1;
                }

                end++;
            }
            return list;
        }
    }
}
