import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9184 {

    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
//            System.out.println("a" +a );
            if(a == -1 && b == -1 && c == -1)
                return;

            int res = recursion(a,b,c);

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + res);
        }

    }

    private static int recursion(int a, int b, int c) {

        if((0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20) && dp[a][b][c] != 0)
            return dp[a][b][c];

        if(a <= 0 || b <= 0 || c <= 0 )
            return 1;
        if(a > 20 || b > 20 || c > 20)
            return dp[20][20][20] = recursion(20, 20, 20);
        if(a < b && b < c)
            return dp[a][b][c] = recursion(a, b, c-1) + recursion(a, b-1, c -1 ) - recursion(a, b-1, c);

        return dp[a][b][c] = recursion(a-1, b, c) + recursion(a-1, b-1, c) + recursion(a-1, b, c-1) - recursion(a-1, b-1, c-1);

    }

}
