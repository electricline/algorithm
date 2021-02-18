import java.util.Scanner;
import java.util.Stack;

public class boj10779 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(' && str.charAt(i+1) == ')'){
                res += stack.size();
                i = i+1;
            } else if(str.charAt(i) == '('){
                stack.add(str.charAt(i));
            } else if(str.charAt(i) == ')'){
                stack.pop();
                res++;
            }
//            System.out.println(res);
        }

        System.out.println(res);

    }

}
