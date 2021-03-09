import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15658 {

    static int n;
    static int[] arr;
    static int[] op;
    static List<Integer> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int depth) {

        if(depth == n-1){
            getMaxandMinValue();
            return;
        }

        for(int i=0; i<4; i++){
            if(op[i] == 0) continue;
            list.add(i);
            op[i] -= 1;
            dfs(depth+1);
            op[i] += 1;
            list.remove(list.size()-1);
        }



    }

    private static void getMaxandMinValue() {

        int sum = arr[0];

        for(int i=0; i<n-1; i++){
            if(list.get(i) == 0){
                sum += arr[i+1];
            } else if(list.get(i) == 1){
                sum -= arr[i+1];
            } else if(list.get(i) == 2){
                sum *= arr[i+1];
            } else if(list.get(i) == 3){
                sum /= arr[i+1];
            }
        }

        max = Math.max(max,sum);
        min = Math.min(min,sum);



    }

}
