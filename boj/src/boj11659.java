import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj11659 {

    static int n, m;
    static int[] arr;
    static int[] sum;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<pair> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            q.add(new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
         }


        sum = new int[n+1];

        for(int i=1; i<=n; i++){
            sum[i] = sum[i-1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){

            pair cur = q.poll();

            int res = sum[cur.b] - sum[cur.a-1];

            sb.append(res).append('\n');


        }

        System.out.println(sb);


    }

    static class pair{
        int a;
        int b;

        pair(int a, int b){
            this.a = a;
            this.b = b;
        }

    }

}

