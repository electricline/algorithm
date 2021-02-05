import java.util.Scanner;

public class boj9461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for(int i=6; i<101; i++){
            dp[i] = dp[i-2] + dp[i-3];
        }
        for(int i=0; i<N ;i++){
            int num = sc.nextInt();
            System.out.println(dp[num]);
        }

    }

}