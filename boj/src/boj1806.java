import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1806 {

    static int n, s;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); s = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

    }

    private static void solve() {


        int left = 0;
        int right = 1;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while(true){

            if(sum < s && right <= n){
                sum += arr[right++];
            } else if(sum >= s && left <=n){
                sum -= arr[left++];
                minLength = Math.min(minLength, right-left+1);
            } else if(right == n+1){
                break;
            }

        }

        if(minLength == Integer.MAX_VALUE){
            System.out.println(0);
        } else
            System.out.println(minLength);


    }

}
