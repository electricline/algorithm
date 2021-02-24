import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0; int right = 1;
        int res = 0;

        // 1 3 4 5 6

        while(right != n){

            if(arr[left] + arr[right] == x){
                res++;
                left++;
                right = left+1;
            } else if(arr[left] + arr[right] > x){
                left++;
                right = left+1;
            } else {
                right++;
            }

            if(right == n && left < n-1){
                left++;
                right = left + 1;
            }

        }

        System.out.println(res);

    }

}
