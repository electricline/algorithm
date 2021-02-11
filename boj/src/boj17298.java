import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj17298 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = new int[n];
        Arrays.fill(res,-1);

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                res[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(res[i]).append(" ");
        }

        System.out.println(sb);


    }

}
