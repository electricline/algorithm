package com.company;

public class MaximumSubarray {

    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0) return 0;

            int sum = nums[0];
            int result = sum;

            for(int end=1; end<nums.length; end++){
                sum = sum+nums[end] >= nums[end] ? sum + nums[end] : nums[end];
                result = Math.max(sum, result);
            }
            return result;
        }
    }

}
