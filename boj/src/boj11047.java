import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, K;
        N = sc.nextInt();
        K = sc.nextInt();
        int res = 0;


        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            int coin = sc.nextInt();
            if(coin > K) continue;
            list.add(coin);
        }

        Collections.sort(list,Collections.reverseOrder());

        for(int i=0; i<list.size(); i++){
            int c = list.get(i);
            res += K/c;
            K = K%c;
            if(K == 0) break;
        }

        System.out.println(res);

    }

}
