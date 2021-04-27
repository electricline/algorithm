import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14501 {

    static int n;
    static int[] t;
    static int[] p;
    static int ret=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(ret);
    }

    private static void dfs(int day, int sum) {

        if(day == n){
            ret = Math.max(ret, sum);
            return;
        }

        if(day+t[day]-1 < n){
            dfs(day + t[day], sum + p[day]);
        }

        dfs(day+1, sum);

    }

}
