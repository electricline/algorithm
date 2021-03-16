import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2644 {

    static int n;
    static int p, c;
    static int k;
    static int[][] map;
    static boolean[] visitied;
    static int res = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visitied = new boolean[n+1];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
            map[c][r] = 1;
        }

        bfs();

        System.out.println(res);
    }

    private static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.add(p);
        q.add(0);

        while(!q.isEmpty()){

            int cur = q.poll();
            int cur_cnt = q.poll();

//            System.out.println("cur " + cur + " cur_cnt " + cur_cnt);

            if(cur == c){
                res = cur_cnt;
                break;
            }

            if(visitied[cur]) continue;
            visitied[cur] = true;


            for(int i=1; i<=n; i++){
                if(map[cur][i] == 0) continue;
                q.add(i);
                q.add(cur_cnt+1);
            }

        }

    }

}
