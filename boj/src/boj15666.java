import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj15666 {

    static int n, m;
    static int[] arr;
    static boolean[] visitied;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new LinkedHashSet<>();
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

        dfs(0, 0);

        sb = new StringBuilder();
        for(String s : set){
            sb.append(s);
        }

        System.out.println(sb);
    }

    private static void dfs(int depth, int idx) {
        if(depth == m){
            sb = new StringBuilder();
            for(int i : list){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            set.add(sb.toString());
            return;
        }

        for(int i=idx; i<n; i++){
            list.add(arr[i]);
            dfs(depth+1, i);
            list.remove(list.size()-1);
        }

    }


}
