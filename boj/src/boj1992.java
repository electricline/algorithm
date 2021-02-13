import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1992 {
    static int n;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            String c = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = c.charAt(j) - '0';
            }
        }

        recursion(n, 0, 0, false);
        System.out.println(sb);
    }

    private static void recursion(int size, int r, int c, boolean flag) {

        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(map[i][j] != map[r][c]){
                    sb.append("(");
                    recursion(size/2, r, c, false);
                    recursion(size/2, r, c+size/2, false);
                    recursion(size/2, r+size/2, c, false);
                    recursion(size/2, r+size/2, c+ size/2, true);
                    sb.append(")");
                    return;
                }
            }
        }

        sb.append(map[r][c]);
    }

}
