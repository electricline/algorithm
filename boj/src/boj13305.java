import java.util.PriorityQueue;
import java.util.Scanner;

public class boj13305 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] distance = new int[n-1];
        for(int i=0; i<n-1; i++){
            distance[i] = sc.nextInt();
        }

        int[] cost = new int[n];
        for(int i=0; i<n; i++){
            cost[i] = sc.nextInt();
        }

        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0; i<n-1; i++){
            pq.add(new pair(cost[i],distance[i]));
        }

        int min_cost = cost[0];
        long res = 0;
        for(int i=0; i<n-1; i++){
            min_cost = Math.min(min_cost, cost[i]);
            res += (long) distance[i] * min_cost;
        }

        System.out.println(res);

    }

    public static class pair implements Comparable<pair>{
        int cost;
        int distance;

        pair(int cost, int distance){
            this.cost = cost;
            this.distance = distance;
        }

        @Override
        public int compareTo(pair o) {
            if(this.cost - o.cost > 0){
                return 1;
            } else if(this.cost == o.cost){
                return 0;
            } else {
                return -1;
            }
        }
    }
}
