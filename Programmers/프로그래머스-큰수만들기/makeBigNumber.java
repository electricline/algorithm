import java.util.HashSet;

public class makeBigNumber {
    static class Solution {
        public String solution(String number, int k) {

            StringBuilder stringBuilder = new StringBuilder();
            int idx = -1;
            char max;
            for(int i=0; i< number.length()-k; i++){
                max = '0';
                for(int j= idx+1; j<=i+k; j++){
                    if(max < number.charAt(j)){
                        max = number.charAt(j);
                        idx = j;
                    }
                }
                stringBuilder.append(max);
            }
            return stringBuilder.toString();
        }
    }
}
