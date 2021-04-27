import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14500 {

    static int n, m;
    static int[][] map;
    static boolean[][] visitied;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int ret = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visitied = new boolean[n][m];


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visitied[i][j] = true;
                dfs(i,j,0,map[i][j]);
                visitied[i][j] = false;
                if (i - 1 >= 0 && j + 2 < m) Shape1(i, j);
                if (j + 2 < m && i + 1 < n) Shape2(i, j);
                if (i + 2 < n && j + 1 < m) Shape3(i, j);
                if (i + 1 < n && i - 1 >= 0 && j + 1 < m) Shape4(i, j);

            }
        }

        System.out.println(ret);

    }

    static void Shape1(int x, int y)
    {
        int Tmp_Sum = 0;
        Tmp_Sum = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 1];
        if (Tmp_Sum > ret) ret = Tmp_Sum;
    }

    static void Shape2(int x, int y)
    {
        int Tmp_Sum = 0;
        Tmp_Sum = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1];
        if (Tmp_Sum > ret) ret = Tmp_Sum;
    }

    static void Shape3(int x, int y)
    {
        int Tmp_Sum = 0;
        Tmp_Sum = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1];
        if (Tmp_Sum > ret) ret = Tmp_Sum;
    }

    static void Shape4(int x, int y)
    {
        int Tmp_Sum = 0;
        Tmp_Sum = map[x][y] + map[x - 1][y + 1] + map[x][y + 1] + map[x + 1][y + 1];
        if (Tmp_Sum > ret) ret = Tmp_Sum;
    }


    private static void dfs(int r, int c, int depth, int sum) {

//        System.out.println(r+","+c +" " + sum);
        if(depth == 3){
            ret = Math.max(ret, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int nr = r + dy[i];
            int nc = c + dx[i];

            if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            if(visitied[nr][nc]) continue;
            visitied[nr][nc] = true;
            dfs(nr,nc, depth+1, sum + map[nr][nc]);
            visitied[nr][nc] = false;

        }


    }


}
