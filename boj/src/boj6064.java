import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6064 {

    static int res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            getYear(M,N,x,y);

        }

    }

    private static void getYear(int m, int n, int x, int y) {

        int max = lcm(m,n);
        int i = 0;
        for(i=x; i<=max; i+=m) {
            int temp = (i % n == 0) ? n : i % n;
            if (temp == y) {
                System.out.println(i);
                break;
            }
        }

        if(i> max){
            System.out.println(-1);
        }

    }

    private static int gcd(int a, int b){
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }

}
