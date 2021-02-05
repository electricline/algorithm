import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new pair(start, end));
        }

        int res = 0;
        pair pair = pq.poll();
        int cur_time = pair.required_time;
        res += 1;
        while(!pq.isEmpty()){
            pair next = pq.poll();

            if(next.start_time < cur_time){
                continue;
            } else {
                System.out.println(next.start_time + " " +next.required_time);
                cur_time = next.required_time;
                res++;
            }
        }

        System.out.println(res);


    }

    static class pair implements Comparable<pair> {

        int start_time;
        int required_time;

        pair(int start_time, int required_time){
            this.start_time = start_time;
            this.required_time = required_time;
        }

        @Override
        public int compareTo(pair o){
            if(this.required_time - o.required_time > 0){
                return 1;
            } else if(this.required_time - o.required_time == 0){
                if(this.start_time - o.start_time > 0){
                    return 1;
                } else if(this.start_time == o.start_time){
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }

    }

}
