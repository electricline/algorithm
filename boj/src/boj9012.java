import java.util.Scanner;
import java.util.Stack;

public class boj9012 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            String str = sc.next();
            if(check(str))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }

    private static boolean check(String str) {

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.add('(');
            } else {
                if( stack.isEmpty())
                    return false;
                stack.pop();
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
