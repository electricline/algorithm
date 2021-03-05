import java.io.*;
import java.util.StringTokenizer;

public class boj15652 {

    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(0,m, 1, n);
        System.out.println(sb);
    }

    private static void dfs(int depth, int target, int idx, int n) throws IOException {
        if(depth == target){
            for (int j : arr) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx; i<=n; i++){
            arr[depth] = i;
            dfs(depth+1, target, i, n);
        }

    }

}
