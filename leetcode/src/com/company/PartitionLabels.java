package com.company;

import java.util.ArrayList;
import java.util.List;

// LeetCode 763
public class PartitionLabels {

    class Solution {
        public List<Integer> partitionLabels(String S) {
            List<Integer> list = new ArrayList<>();

            int[] lastIdx = new int[26];

            for(int i=0; i<S.length(); i++){
                lastIdx[S.charAt(i) - 'a'] = i;
            }

            int startIdx = 0; int recordIdx = 0;

            for(int i=0; i<S.length(); i++){
                recordIdx = Math.max(recordIdx, lastIdx[S.charAt(i) - 'a']);

                if(recordIdx == i){
                    list.add(recordIdx - startIdx + 1);
                    startIdx = i + 1;
                }

            }

            return list;
        }
    }
}
