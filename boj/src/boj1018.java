import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1018 {

    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];


        // 배열 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;		// W일 때는 true
                } else {
                    arr[i][j] = false;		// B일 때는 false
                }

            }
        }


        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    private static void find(int start_r, int start_c) {

        int end_r = start_r + 8;
        int end_c = start_c + 8;

        boolean color = arr[start_r][start_c];

        int cnt = 0;
        for(int i=start_r; i<end_r; i++){
            for(int j=start_c; j<end_c; j++){

                if(!arr[i][j]  == color){
                    cnt++;
                }
                color = !color;
            }
            color = !color;
        }
        cnt = Math.min(cnt, 64-cnt);
        min = Math.min(min, cnt);
    }

}
