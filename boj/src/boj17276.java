import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17276 {

    static int t, n, d;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t-- > 0){

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            if(d < 0) d += 360;

            map = new int[n][n];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            while(d > 0){
                move();
                d -= 45;
            }
            for (int i=0; i <n; i++) {
                for (int j=0; j<n; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append('\n');
            }

        }

        System.out.println(sb);

    }

    private static void move() {

        int[][] tempMap = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                tempMap[i][j] = map[i][j];
            }
        }

        for(int i=0; i<n; i++){
            tempMap[i][n/2] = map[i][i];
            tempMap[i][n-1-i]= map[i][n/2];
            tempMap[n/2][i] = map[n-1-i][i];
            tempMap[i][i] = map[n/2][i];
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = tempMap[i][j];
            }
        }

    }

}
