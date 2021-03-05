import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj15654 {
    static int n, m;
    static int[] arr;
    static boolean[] visitied;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visitied = new boolean[n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if(depth == m){
            for(int i : list){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(visitied[i]) continue;
            visitied[i] = true;
            list.add(arr[i]);
            dfs(depth+1);
            list.remove(list.size()-1);
            visitied[i] = false;
        }



    }
}
