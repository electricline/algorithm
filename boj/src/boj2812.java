import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        ArrayDeque<Integer> dq = new ArrayDeque();
        dq.add(str.charAt(0) - '0');

        for(int i=1; i<n; i++){
            while(k > 0 && !dq.isEmpty() && dq.peekLast() < (str.charAt(i) - '0') ){
                dq.removeLast();
                k--;
            }
            dq.addLast(str.charAt(i) -'0');
        }

        StringBuilder sb = new StringBuilder();
        while(dq.size() > k){
            sb.append(dq.pollFirst());
        }

        System.out.println(sb.toString());
    }
}
