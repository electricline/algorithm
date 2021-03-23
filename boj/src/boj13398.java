import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13398 {

    static int n;
    static int[] arr;
    static int res = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(res);


    }

    private static void solve() {


        int[][] dp = new int[n+1][2];
        dp[1][0] = arr[1];
        dp[1][1] = arr[1];
        res = arr[1];
        for(int i=2; i<=n; i++){
            dp[i][0] = Math.max(dp[i-1][0]+ arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + arr[i]);
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }

    }
}
