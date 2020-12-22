package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartionLabels2 {

    class Solution {

        public List<Integer> partitionLabels(String S){
            List<Integer> list = new ArrayList();
            int[] arr = new int[26];

            for(int i=0; i<S.length(); i++){
                arr[S.charAt(i) - 'a']++;
            }

            int i = 0, j = 0, l = S.length(), counter = 0;
            HashSet<Character> set = new HashSet<>();

            while(j < l){
                char c = S.charAt(j);

                if(!set.contains(c)){
                    set.add(c);
                    counter++;
                }

                arr[c-'a']--;
                j++;
                if(arr[c-'a'] == 0){
                    counter--;
                    set.remove(c);
                }



                if(counter == 0){
                    list.add(j-i);
                    i = j;
                }
            }

            return list;
        }

    }
}
