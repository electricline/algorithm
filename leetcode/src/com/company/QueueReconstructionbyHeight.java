package com.company;

import java.util.*;

public class QueueReconstructionbyHeight {

    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            if(people.length == 0) return new int[0][0];

            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] == o2[0]) return o1[1] - o2[1];
                    return o2[0]-o1[0];
                }
            });

            List<int[]> list = new ArrayList();

            for(int i=0; i<people.length; i++){
                list.add(people[i][1], new int[]{people[i][0], people[i][1]});
            }
            return list.toArray(new int[0][0]);
        }
    }

}
