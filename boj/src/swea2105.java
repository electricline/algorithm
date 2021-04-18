import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution4
{
    static int n;
    static int[][] map;
    static boolean[][] check;
    /*
       오른쪽 위, 오른쪽 아래,왼쪽 아래, 왼쪽 위
     */
    static int[] dy = {-1,1,1,-1};
    static int[] dx = {1,1,-1,-1};
    static boolean[] visitied;
    static int res = 0;
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            check = new boolean[n][n];
            res = -1;
            visitied = new boolean[101];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    check[i][j] = false;
                }
            }

            solve();

            System.out.println("#"+test_case+ " " + res);

        }
    }

    private static void solve() {

        for(int i=1; i<n-1; i++){
            for(int j=0; j<n-2; j++){
                check[i][j] = true;
                visitied[map[i][j]] = true;
                dfs(i, j, i, j, 1, 0);
                visitied[map[i][j]] = false;
                check[i][j] = false;
            }
        }


    }

    private static void dfs(int sr, int sc, int r, int c, int depth, int dir) {

        for(int i=0; i<2; i++){
            if(dir + i == 4 ) return;
            int n_dir = (dir + i) % 4;
            int nr = r + dy[n_dir];
            int nc = c + dx[n_dir];

            if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
            if(sr == nr && sc == nc) {
                res = Math.max(res, depth);
            }
            if(check[nr][nc]) continue;
            if(visitied[map[nr][nc]]) continue;

            check[nr][nc] = true;
            visitied[map[nr][nc]] = true;
            dfs(sr, sc, nr, nc, depth+1, n_dir);
            visitied[map[nr][nc]] = false;
            check[nr][nc] = false;
        }
    }
}