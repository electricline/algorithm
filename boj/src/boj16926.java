import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj16926 {

    static int n, m, r, minRotate;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minRotate = Math.min(n,m) / 2;

        for(int i=0; i<r; i++){
            rotate();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }



    }

    private static void rotate() {

        for(int i=0; i<minRotate; i++){
            int r = i;
            int c = i;
            int temp = map[r][c];


            int idx = 0;
            while(idx < 4){

                int nr = r + dr[idx];
                int nc = c + dc[idx];

                if(nr >= i && nc >= i && nr < n-i && nc < m-i){
                    map[r][c] = map[nr][nc];
                    r = nr;
                    c = nc;
                } else {
                    idx++;
                }
            }
            map[i+1][i] = temp;
        }
    }

}
