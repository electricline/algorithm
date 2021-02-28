import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class lifeBoat {
    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            int left_idx = 0; int right_idx = people.length-1;

            while(left_idx <= right_idx){
                if(people[left_idx] + people[right_idx] <= limit){
                    right_idx--;
                    left_idx++;
                }else{
                    right_idx--;
                }
                answer++;
            }
            return answer;
        }
    }
}
