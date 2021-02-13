import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1780 {

    static int n;
    static int[][] map;
    static int zero = 0;
    static int one = 0;
    static int minusOne = 0;
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

        recursion(n, 0 ,0);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void recursion(int size, int r, int c) {

        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(map[i][j] != map[r][c]){
                    recursion(size/3, r,c);
                    recursion(size/3, r , c + size/3);
                    recursion(size/3, r, c + 2*(size/3));
                    recursion(size/3, r +size/3, c);
                    recursion(size/3, r + size/3, c+size/3);
                    recursion(size/3, r+ size/3, c+2*(size/3));
                    recursion(size/3, r + 2*(size/3) , c);
                    recursion(size/3, r + 2*(size/3) , c+size/3);
                    recursion(size/3, r + 2*(size/3) , c+2*(size/3));
                    return;
                }
            }
        }

        if(map[r][c] == 0){
            zero++;
        } else if(map[r][c] == -1){
            minusOne++;
        } else {
            one++;
        }

    }

}
