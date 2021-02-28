import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int temp = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i: scoville){
            heap.offer(i);
        }
        
        while(true){
            
            if(heap.peek() >= K)
                break;
            
            if(heap.peek() == 0 || heap.size() == 1){
                return -1;
            }
            
            int min = heap.poll();
            int second = heap.poll();
            
            temp = min+ 2*second;
            
            heap.offer(temp);
            answer++;
        }
        return answer;
        
    }
}