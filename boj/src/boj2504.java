import java.util.Scanner;
import java.util.Stack;

public class boj2504 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(' && str.charAt(i+1) == ')'){
                stack.add('2');
                i++;
            }

        }


    }
}
