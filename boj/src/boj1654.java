import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        for(int i=0; i<k; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        binarySearch(arr, n, k);

    }

    private static void binarySearch(int[] arr, int n, int k) {

        long left = 1;
        long right = arr[arr.length-1];
        long ans = 0;

        while(left<=right){

            long mid = (left + right)/2;
            long res = 0;

            for(int i=0; i<arr.length; i++){
                res += arr[i]/mid;
            }

            if(res >= n){
                ans = Math.max(mid, ans);
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(ans);

    }

}
