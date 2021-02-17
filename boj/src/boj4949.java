import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            if(str.equals("."))
                return;
            boolean flag = false;
            for(int i=0; i<str.length(); i++){
//                System.out.println(stack);
                if(str.charAt(i) == '(' || str.charAt(i) == '['){
                    stack.add(str.charAt(i));
                } else if(str.charAt(i) == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    } else {
                        System.out.println("no");
                        flag = true;
                        break;
                    }
                } else if(str.charAt(i) == ']'){
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    } else {
                        System.out.println("no");
                        flag = true;
                        break;
                    }
                } else {
                    continue;
                }
            }

            if(!flag && stack.isEmpty()){
                System.out.println("yes");
            } else if(!flag){
                System.out.println("no");
            }
        }

    }

}
