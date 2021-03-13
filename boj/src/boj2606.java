import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2606 {

    static int n, k;
    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            map[r][c] = 1;
            map[c][r] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visitied = new boolean[n];
        int res = 0;
        visitied[0] = true;
        while(!q.isEmpty()){

            int cur = q.poll();

            for(int i=0; i<n; i++){
                if(visitied[i] || map[cur][i] == 0) continue;
                visitied[i] = true;
                q.add(i);
                res++;
            }
        }

        System.out.println(res);


    }

}
