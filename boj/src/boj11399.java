import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] p = new int[N];
        for(int i=0; i<N; i++) {
            p[i] = sc.nextInt();
        }

        Arrays.sort(p);

        int res = 0;

        int[] cache = new int[N];
        cache[0] = p[0];
        for(int i=1; i<p.length; i++){
            cache[i] = cache[i-1] + p[i];
        }

        for(int i=0; i<cache.length; i++){
            res += cache[i];
        }

        System.out.println(res);
    }

}
