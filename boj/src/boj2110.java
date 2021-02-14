import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        binarySearch(arr, n, c);

    }

    private static void binarySearch(int[] arr, int n, int c) {

        long left = 1;
        long right = arr[arr.length-1] - arr[0];
        long ans = 0;
        long distacne = 0;

        while(left<=right){
            long cnt = 0;
            int start = 0;
            long mid = (left + right) / 2;

            for(int i=1; i<n; i++){
                distacne = arr[i] - arr[start];
                if(mid <= distacne){
                    cnt++;
                    start = i;
                }
            }

            if(cnt >= c-1){
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);

    }

}
