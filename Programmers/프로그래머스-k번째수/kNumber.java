import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class kNumber {
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            int cnt;
            for(int i=0; i<commands.length; i++){
                int[] temp = new int[commands[i][1]-commands[i][0]+1];
                cnt = 0;
                for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++){
                    temp[cnt] = array[j];
//                    System.out.println("j = " + j + " array[j] = " + array[j] );
                    cnt++;
                }
                Arrays.sort(temp);
                for(int k=0; k<temp.length; k++){
                    System.out.print(" " + temp[k]);
                }
                answer[i] = temp[commands[i][2]-1];
                System.out.println();
            }

            return answer;
        }
    }
}
