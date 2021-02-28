import java.util.Locale;

public class programmers1 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution("=.="));

    }

    static class Solution {
        public String solution(String new_id) {
            String answer = "";

            // step 1 대문자 -> 소문자
            new_id = new_id.toLowerCase();

            // step 2
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<new_id.length(); i++){
                if(Character.isAlphabetic(new_id.charAt(i))){
                    sb.append(new_id.charAt(i));
                } else if (Character.isDigit(new_id.charAt(i))) {
                    sb.append(new_id.charAt(i));
                } else if(new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.'){
                    sb.append(new_id.charAt(i));
                }
            }
            new_id = sb.toString();
            sb = new StringBuilder();

            // step 3
            for(int i=0; i<new_id.length(); i++){
                sb.append(new_id.charAt(i));
                if(new_id.charAt(i) == '.'){
                    while(true){
                        if(i < new_id.length()-1 && new_id.charAt(i) == new_id.charAt(i+1)){
                            i++;
                        } else {
                            break;
                        }
                    }
                }
            }
            new_id = sb.toString();

            // step 4
            if(new_id.length() >= 1 && new_id.charAt(0) == '.')
                new_id = new_id.substring(1);
            if(new_id.length() >= 1 && new_id.charAt(new_id.length()-1) == '.')
                new_id = new_id.substring(0, new_id.length()-1);

            if(new_id.length() == 0){
                new_id = "a";
            }

            if(new_id.length() >= 16){
                new_id = new_id.substring(0, 15);
            }

            while(true){
                if(new_id.charAt(new_id.length()-1) == '.'){
                    new_id = new_id.substring(0, new_id.length()-1);
                } else {
                    break;
                }
            }

            if(new_id.length() <= 2){
                while(true){
                    if(new_id.length() == 3){
                        break;
                    } else {
                        String temp = String.valueOf(new_id.charAt(new_id.length()-1));
                        new_id = new_id + temp;
                    }
                }
            }


            return new_id;
        }
    }

}
