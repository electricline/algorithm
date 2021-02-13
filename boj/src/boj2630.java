import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2630 {
    static int[][] map;
    static int n;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(n, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int size, int sr, int sc){

        for(int i=sr; i<sr + size; i++){
            for(int j=sc; j<sc + size; j++){
                if(map[i][j] != map[sr][sc]){
                    divide(size/2, sr, sc);
                    divide(size/2, sr + size/2, sc);
                    divide(size/2, sr, sc + size/2);
                    divide(size/2, sr + size/2,sc + size/2);
                    return;
                }
            }
        }

        if(map[sr][sc] == 1)
            blue++;
        else
            white++;
    }

}
