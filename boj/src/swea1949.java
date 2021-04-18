import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution3
{
    static int[][] map;
    static int n,k;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static Queue<pair> q;
    static int res;
    static boolean[][] visitied;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            q = new LinkedList<>();
            res = 0;
            int max = 0;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] > max){
                        max = map[i][j];
                        q.clear();
                        q.add(new pair(i,j));
                    } else if(map[i][j] == max){
                        q.add(new pair(i,j));
                    }
                }
            }

            solve();

            System.out.println("#" + test_case + " " + res);

        }
    }

    private static void solve() {

        while(!q.isEmpty()){
            pair cur = q.poll();
            visitied = new boolean[n][n];
            visitied[cur.r][cur.c] = true;
            dfs(cur.r,cur.c, 1, true);
            visitied[cur.r][cur.c] = false;
        }


    }

    private static void dfs(int r, int c, int depth, boolean flag) {

        res = Math.max(depth, res);

        for(int dir=0; dir<4; dir++){

            int nr = r + dy[dir];
            int nc = c + dx[dir];
            if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
            if(visitied[nr][nc]) continue;

            if(map[nr][nc] >= map[r][c]){
                if(flag){
                    for(int i=1; i<=k; i++){
                        int origin = map[nr][nc];
                        int temp = map[nr][nc] - i;
                        if(temp < map[r][c]){
                            visitied[nr][nc] = true;
                            map[nr][nc] = temp;
                            dfs(nr, nc, depth+1, false);
                            map[nr][nc] = origin;
                            visitied[nr][nc] = false;
                        }
                    }
                }
            } else {
                visitied[nr][nc] = true;
                dfs(nr, nc, depth+1, flag);
                visitied[nr][nc] = false;
            }
        }
    }

    private static class pair {
        int r;
        int c;
        int k;
        int cnt;
        boolean flag;

        pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        pair(int r, int c, int k, int cnt, boolean flag) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.cnt = cnt;
            this.flag = flag;
        }
    }
}