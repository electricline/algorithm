import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution10
{
    static int n, k, ret;
    static int[][] map;
    static int[][] reverse_map;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            reverse_map = new int[n][n];
            ret = 0;

            for(int i=0;i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    reverse_map[j][i] = map[i][j];
                }
            }

            for(int i=0; i<n; i++){
                if(rowCheck(i, map)){
                    ret++;
                }
            }

            for(int i=0; i<n; i++){
                if(rowCheck(i, reverse_map)){
                    ret++;
                }
            }

            System.out.println("#" + test_case + " " + ret);
        }
    }

    private static boolean rowCheck(int row, int[][] map) {

        int count = 1;
        for(int i=1; i<n; i++){
            int prev = map[row][i - 1];
            int cur = map[row][i];
            if(prev - cur == 1 && count >= 0){ // 아래 경사로
                count =  -k + 1;
            } else if(prev - cur == -1 && count >= k){
                count = 1;
            } else if(prev == cur){
                count++;
            } else {
                return false;
            }
        }

        if(count >= 0) {
            return true;
        } else {
            return false;
        }

    }
}