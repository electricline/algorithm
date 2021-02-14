import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj1300 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        binarySearch(n,k);

    }

    private static void binarySearch(int n, int k) {

        long left = 1;
        long right = k;
        long ans = 0;

        while(left<=right){
            long cnt = 0;
            long mid = (left + right) / 2;

            for(int i=1; i<=n; i++){
                cnt += Math.min(mid/i, n);
            }

            if(cnt >= k){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);

    }

}
