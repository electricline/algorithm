import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2003 {

    static int n, m;
    static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int l = 1;
        int r = 1;
        int sum = 0;
        int res = 0;

        while(true){


            if(sum >= m) {
                sum -= nums[l];
                l++;
            } else if(r == n+1){
                break;
            } else {
                sum += nums[r];
                r++;
            }

            if(sum == m){
                res++;
            }



        }

        System.out.println(res);



    }

}
