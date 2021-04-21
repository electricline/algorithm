import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution7
{
    static int n,m;
    static int[][] map;
    static boolean[][] visitied;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int res;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            res = 0;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve();

            System.out.println("#"+test_case+" " + res);

        }
    }

    private static void solve() {

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                bfs(i,j);
            }
        }

    }

    private static void bfs(int r, int c) {

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(r,c));
        visitied = new boolean[n][n];
        visitied[r][c] = true;
        int house_count = 0;
        if(map[r][c] == 1)
            house_count++;


        for(int k=1; k<=n+1; k++){

            if(house_count * m - getOperationFee(k) >= 0){
                res = Math.max(res, house_count);
            }

            int S = q.size();

            for(int qs=0; qs<S; qs++){

                pair cur = q.poll();

                for(int dir=0; dir<4; dir++){

                    int nr = cur.r + dy[dir];
                    int nc = cur.c + dx[dir];

                    if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                    if(visitied[nr][nc]) continue;

                    q.add(new pair(nr,nc));
                    if(map[nr][nc] == 1) house_count++;
                    visitied[nr][nc] = true;
                }
            }
        }

    }


    static int getOperationFee(int k)
    {
        return (k * k) + (k - 1)*(k - 1);
    }

    static class pair {
        int r;
        int c;
        int depth;

        pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }


}