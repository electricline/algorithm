package com.company;

import java.util.Arrays;

public class KthLargestElementinanArray {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length-k];
        }
    }
}
