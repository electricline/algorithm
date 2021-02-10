import java.util.Scanner;
import java.util.Stack;

public class boj10773 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<k; i++){
            int n = sc.nextInt();
            if(n == 0){
                stack.pop();
            } else {
                stack.add(n);
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }

        System.out.println(res);

    }
}
