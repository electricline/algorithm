package com.company;

import java.util.HashMap;
import java.util.Map;

public class FindtheDuplicateNumber {

    class Solution {
        public int findDuplicate(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<nums.length; i++){
                if(map.containsKey(nums[i]))
                    return nums[i];
                map.put(nums[i], 1);
            }
            return 0;
        }
    }
}
