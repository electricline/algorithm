package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ramenFactory {
    static class Solution {
        public int solution(int stock, int[] dates, int[] supplies, int k) {
            int answer = 0;

            int total_stock = stock;
            int idx = 0;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue(Comparator.reverseOrder());
            while(total_stock < k){
                while(idx <dates.length && dates[idx] <= total_stock){
                    priorityQueue.offer(supplies[idx++]);
                }
                total_stock += priorityQueue.poll();
                answer++;
            }

            return answer;
        }
    }
}
