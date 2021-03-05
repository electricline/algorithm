import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15650 {

    static boolean[] visitied;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visitied = new boolean[n+1];

        dfs(0,m, 1, n);
    }

    private static void dfs(int depth, int target, int idx, int n) {
        if(depth == target){
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
            return;
        }

        for(int i=idx; i<=n; i++){
            if(visitied[i]) continue;
            visitied[i] = true;
            arr[depth] = i;
            dfs(depth+1, target, i+1, n);
            visitied[i] = false;
        }

    }
}
