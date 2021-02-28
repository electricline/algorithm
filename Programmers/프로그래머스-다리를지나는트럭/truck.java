import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> bridgeQ = new LinkedList<Integer>();
        int[] arrTime = new int[truck_weights.length];
        int time = 0;
        int idx = 0;
        
        while(true){
            
            // 트럭이 도착할 경우 다리에서 제거해준다.
            if(!bridgeQ.isEmpty() && arrTime[bridgeQ.peek()] == time){
                weight += truck_weights[bridgeQ.poll()];
            }
            
            // 트럭을 추가할 경우
            if(idx < truck_weights.length && truck_weights[idx] <= weight){                
                bridgeQ.add(idx);
                weight -= truck_weights[idx];
                arrTime[idx] = time + bridge_length;
                idx++;    
            }
            
            time++;
            if(bridgeQ.isEmpty())
                break;
        }
        
        return time;
    }
}