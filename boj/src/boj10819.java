import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj10819 {
    static int n;
    static int[] arr;
    static boolean[] visitied;
    static List<Integer> list = new ArrayList<>();
    static int res;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visitied = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0);

        System.out.println(res);

    }

    private static void dfs(int depth) {
        if(depth == n){
            getMaxValue();
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

    private static void getMaxValue() {

        int sum = 0;

        for(int i=0; i<n-1; i++){
            sum += Math.abs(list.get(i) - list.get(i+1));
        }

        res = Math.max(sum, res);

    }
}
