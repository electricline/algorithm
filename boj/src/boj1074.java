import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1074 {

    static int res;
    static int R,C;
    public static int[] dr = {0, 0, 1, 1};
    public static int[] dc = {0, 1, 0, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = (int) Math.pow(2, n);

        recursion(N, 0, 0, 0);

        System.out.println(res);

    }

    private static void recursion(int size, int r, int c, int cnt) {

        if(r > R || c > C || r + size <= R  || c + size <= C) return;

        if(size == 2){
            for(int i=0; i<4; i++){

                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr == R  && nc == C){
                    res = cnt + i;
                }
            }
            return;
        }

        int nextSize = size/2;

        recursion(nextSize, r, c, cnt);
        recursion(nextSize, r, c + nextSize, cnt + (nextSize * nextSize));
        recursion(nextSize, r + nextSize, c, cnt + (nextSize * nextSize * 2));
        recursion(nextSize, r + nextSize, c + nextSize, cnt + (nextSize * nextSize * 3));

    }

}