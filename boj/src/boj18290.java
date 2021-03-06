import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj18290 {

    static int n, m, k;
    static int[][] map;
    static boolean[][] visitied;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int res = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visitied = new boolean[n][m];

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }


        dfs( 0, 0);
        System.out.println(res);
    }

    private static void dfs(int depth, int sum) {

        if(depth == k){
            res = Math.max(res,sum);
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                boolean flag = false;
                for(int dir=0; dir<4; dir++){
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];
                    if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if(visitied[nr][nc]){
                        flag = true;
                        break;
                    }
                }
                if(flag) continue;
                if(visitied[i][j]) continue;
                visitied[i][j] = true;
                dfs(depth+1, sum + map[i][j]);
                visitied[i][j] = false;

            }
        }

    }

}
