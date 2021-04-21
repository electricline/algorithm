import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution9
{
    static int[] op_count;
    static int[] num_arr;
    static int n;
    static int MIN;
    static int MAX;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            num_arr = new int[n];
            op_count = new int[4];
            MIN = Integer.MAX_VALUE;
            MAX = Integer.MIN_VALUE;
            String[] temp = br.readLine().split(" ");
            for(int i=0; i<4; i++){
                op_count[i] = Integer.parseInt(temp[i]);
//                System.out.print(op_count[i] + " ");
            }

            temp = br.readLine().split(" ");
            for(int i=0; i<n; i++){
                num_arr[i] = Integer.parseInt(temp[i]);
            }

            dfs(1, num_arr[0]);

            System.out.println("#"+test_case+" "+(MAX-MIN));

        }
    }


    private static void dfs(int depth, int sum) {
        if(depth == n){
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }

        if(op_count[0] > 0) {
            op_count[0] -= 1;
            dfs(depth + 1, sum + num_arr[depth]);
            op_count[0] += 1;
        }
        if(op_count[1] > 0) {
            op_count[1] -= 1;
            dfs(depth + 1, sum - num_arr[depth]);
            op_count[1] += 1;
        }
        if(op_count[2] > 0) {
            op_count[2] -= 1;
            dfs(depth + 1, sum * num_arr[depth]);
            op_count[2] += 1;
        }
        if(op_count[3] > 0) {
            op_count[3] -= 1;
            dfs(depth + 1, sum / num_arr[depth]);
            op_count[3] += 1;
        }


    }
}