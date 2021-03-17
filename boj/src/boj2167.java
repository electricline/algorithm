import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2167 {

    static int res = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] map = new int[y][x];

        for(int i=0; i<y; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<x; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            solve(map, a, b, c, d);

            System.out.println(res);

        }


    }

    private static void solve(int[][] map, int a, int b, int c, int d) {

        int sum = 0;
        for(int i=a; i<=c; i++){
            for(int j=b; j<=d; j++){
                sum += map[i][j];
            }
        }

        res = sum;
    }

}
