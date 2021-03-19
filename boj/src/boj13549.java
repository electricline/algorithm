import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj13549 {

    static int n, k;
    static int res = Integer.MAX_VALUE;
    static int[] visitied = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); k = sc.nextInt();
        Arrays.fill(visitied, Integer.MAX_VALUE);
        bfs();

        System.out.println(res);

    }

    private static void bfs() {

        Queue<Integer> q = new LinkedList();
        q.add(n);
        visitied[n] = 0;

        while(!q.isEmpty()){

            int cur = q.poll();

            if(cur == k){
                res = visitied[cur];
                return;
            }

            if(cur-1 >= 0 && visitied[cur-1] > visitied[cur] + 1){
                visitied[cur-1] = visitied[cur]+1;
                q.add(cur-1);
            }

            if(cur+1 <= 100000 && visitied[cur+1] > visitied[cur] + 1){
                visitied[cur+1] = visitied[cur]+1;
                q.add(cur+1);
            }

            if(cur*2 <= 100000 && visitied[cur*2] > visitied[cur]){
                visitied[cur*2] = visitied[cur];
                q.add(cur*2);
            }


        }

    }
}
