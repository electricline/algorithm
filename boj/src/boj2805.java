import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        binarySearch(arr, n, m);

    }

    private static void binarySearch(int[] arr, int n, int m) {

        long left = 1;
        long right = arr[arr.length-1];
        long ans = 0;
        while(left<=right){

            long mid = (left + right) / 2;
            long res = 0;
            for(int i=0; i<arr.length; i++){
                long temp = arr[i] - mid;
                if(temp > 0)
                    res += temp;
            }

            if(res >= m){
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(ans);

    }

}
