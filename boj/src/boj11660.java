import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11660 {

    static int r, k;
    static int[][] map;
    static int[][] sum;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());

        map = new int[r+1][r+1];

        for(int i=1; i<=r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=r; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sum = new int[r+1][r+1];

        for(int i=1; i<=r; i++){
            int temp = 0;
            for(int j=1; j<=r; j++){
                sum[i][j] = temp + map[i][j];
                temp = sum[i][j];
            }
        }


        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            solve(a,b,c,d);

        }

        System.out.println(sb);



    }

    private static void solve(int a, int b, int c, int d) {

        int temp = 0;
        for(int i=a; i<=c; i++){
            temp += sum[i][d] - sum[i][b-1];
        }

        sb.append(temp).append('\n');
    }
}
