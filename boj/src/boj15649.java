import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15649 {

    static boolean[] visitied;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visitied = new boolean[n+1];
        
        dfs(0,m, n);


    }

    private static void dfs(int depth, int target, int n) {
        if(target == depth){
            for(int i=0; i<arr.length; i++){
                System.out.print(arr[i] +" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++){
            if(visitied[i]) continue;
            visitied[i] = true;
            arr[depth] = i;
            dfs(depth+1, target, n);
            visitied[i] = false;
        }

    }
}
