import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution5
{
    static int n, m, k;
    static int[][] map;
    static int[][] dirMap;
    static int[][] sumMap;
    static int[] dy = {0,-1,1,0,0};
    static int[] dx = {0,0,0,-1,1};
    static boolean[][] visitied;
    static List<pair> list;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            dirMap = new int[n][n];
            sumMap = new int[n][n];
            visitied = new boolean[n][n];
            list = new ArrayList<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i == 0 || j == 0 || i == n-1 || j == n-1)
                        visitied[i][j] = true;
                }
            }

            for(int i=1; i<=k; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int t_num = Integer.parseInt(st.nextToken());
                int t_d = Integer.parseInt(st.nextToken());
                list.add(new pair(r,c,t_d,t_num));
            }

            while(m-->0){
                move();
            }

            int res = 0;

            for(int i=0; i<list.size(); i++){
                res += list.get(i).num;
            }

            System.out.println("#"+test_case + " " + res);

        }
    }

    private static void move() {

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sumMap[i][j] = 0;
                map[i][j] = 0;
                dirMap[i][j] = 0;
            }
        }


        for(int i=0; i<list.size(); i++){

            pair cur = list.get(i);

            int nr = cur.r + dy[cur.d];
            int nc = cur.c + dx[cur.d];

            if(visitied[nr][nc]){

                cur.num = cur.num / 2;
                if(cur.d == 1){
                    cur.d = 2;
                } else if(cur.d == 2){
                    cur.d = 1;
                } else if(cur.d == 3){
                    cur.d = 4;
                } else if(cur.d == 4){
                    cur.d = 3;
                }
            }

//            if(cur.num == 0) continue;

            if(map[nr][nc] == 0){
                map[nr][nc] = cur.num;
                dirMap[nr][nc] = cur.d;
                sumMap[nr][nc] = cur.num;
            } else {
                if(map[nr][nc] < cur.num){
                    map[nr][nc] = cur.num;
                    dirMap[nr][nc] = cur.d;
                }
                sumMap[nr][nc] += cur.num;
            }
        }

        List<pair> tempList = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] > 0){
                    tempList.add(new pair(i,j,dirMap[i][j], sumMap[i][j]));
                }
            }
        }

        list = tempList;

    }

    static class pair {

        int r;
        int c;
        int d;
        int num;
        boolean alive;
        int idx;

        pair(int r, int c, int d, int num){
            this.r = r;
            this.c = c;
            this.d = d;
            this.num = num;
        }

    }
}