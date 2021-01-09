package com.company;

public class FindtheSmallestDivisorGivenaThreshold {

    class Solution {
        long res;
        public int smallestDivisor(int[] nums, int threshold) {

            long left = 1;
            long right = Integer.MAX_VALUE;

            while(left < right){
                long mid = left + (right-left)/2;
                res = findSum(nums, mid);
                if(res > threshold){
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return (int) left;
        }

        private long findSum(int[] nums, long left) {

            int sum = 0;

            for(int i=0; i<nums.length; i++){
                if(nums[i]%left == 0){
                    sum += nums[i]/left;
                } else {
                    sum += nums[i]/left + 1;
                }
            }

            return sum;

        }

    }

}
