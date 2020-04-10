package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class camouflage {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> hashMap = new HashMap<>();

            for(int i=0; i<clothes.length; i++){
                hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1],0)+1);
            }

            for(String s : hashMap.keySet()){
                answer = answer * hashMap.get(s);
            }

            return answer-1;
        }
    }
}
