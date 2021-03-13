import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj12761 {

    static int a, b, n, m;
    static int[] move;
    static boolean[] visitied = new boolean[100001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        move = new int[]{-1, 1, a, -a, b, -b,};
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(n,0));
        visitied[n] = true;
        while(!q.isEmpty()){

            pair cur = q.poll();
            if(cur.idx == m){
                System.out.println(cur.cnt);
                return;
            }
            int nr = 0;
            for(int i=0; i<6; i++){
                nr = cur.idx + move[i];
                if(nr < 0 || nr > 100000) continue;
                if(visitied[nr]) continue;
                q.add(new pair(nr, cur.cnt+1));
                visitied[nr] = true;
            }

            for(int i=0; i<2; i++){

                if(i==0){
                    nr = cur.idx*a;
                } else {
                    nr = cur.idx*b;
                }

                if(nr < 0 || nr > 100000) continue;
                if(visitied[nr]) continue;
                q.add(new pair(nr, cur.cnt+1));
                visitied[nr] = true;
            }

        }

    }

    static class pair {
        int idx;
        int cnt;

        pair(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }

}
