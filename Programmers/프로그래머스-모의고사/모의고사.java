import java.util.*;

public class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int[][] arr = new int[3][10];
        int[] first = {1,2,3,4,5}; int[] second =  {2,1,2,3,2,4,2,5}; int[] third = {3,3,1,1,2,2,4,4,5,5};
        arr[0] = first; arr[1] = second; arr[2] = third;
        int temp = 0; int idx = 1;
        
        for(int k=0; k<3; k++){

            int idx2=0;
            int cnt = 0;
            for(int i=0; i<answers.length; i++){
                if(answers[i] == arr[k][idx2]){ //  같은 값 비교
                    cnt++;
                }
                idx2++; // 끝났으니 올림

                if(idx2 == arr[k].length){ // 길이가 같을 경우 인덱스 번호를 초기화
                    idx2 = 0;
                }
            }

            if( cnt > temp){
                temp = cnt;
                list.clear();
                list.add(idx);
            } else if(cnt == temp){
                temp = cnt;
                list.add(idx);
                
            } else {
                
            }
            idx++;
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}