import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str_number = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            str_number[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str_number, new Comparator<String>(){
            @Override
            public int compare(String num, String num2) {
                return (num2+num).compareTo(num+num2);
            }
        });
        
        if(str_number[0].equals("0")){
            return "0";
        }
        
        for(int i=0; i<numbers.length; i++){
            answer += str_number[i];
        }        
        
        
        return answer;
    }
}