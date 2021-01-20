package com.company;

import java.util.*;

public class TopKFrequentElements {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap();

            for(int i=0; i<nums.length; i++){
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }


            List<pair> list = new ArrayList();

            for(Integer key : map.keySet()){
                list.add(new pair(key, map.get(key)));
            }

            Collections.sort(list);

            int[] res = new int[k];

            for(int i=0; i<k; i++){
                res[i] = list.get(i).num;
            }

            return res;
        }

        class pair implements Comparable<pair>{

            int num;
            int cnt;

            pair(int num, int cnt){
                this.num = num;
                this.cnt = cnt;
            }

            @Override
            public int compareTo(pair o) {

                if(o.cnt - this.cnt > 0)
                    return 1;
                else if(o.cnt -this.cnt == 0)
                    return 0;
                else
                    return -1;
            }
        }

    }
}
