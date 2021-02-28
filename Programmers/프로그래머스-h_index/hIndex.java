import java.util.Arrays;

public class hIndex {
    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            int cite;
            Arrays.sort(citations);
            for(int i=0; i<citations.length; i++) {
                cite = citations.length - i;

                if(citations[i]>=cite){
                    answer = cite;
                    break;
                }


            }

            return answer;
        }
    }
}
