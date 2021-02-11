import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class boj1874 {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();	// 출력할 결과물 저장

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){

            int val = Integer.parseInt(br.readLine());

            if(val > cnt){

                for(int i=cnt+1; i <= val; i++){
                    stack.push(i);
                    sb.append('+');
                    sb.append('\n');
                }
                cnt = val;
            } else if(val != stack.peek()) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-');
            sb.append('\n');

        }

        System.out.println(sb);

    }

}
