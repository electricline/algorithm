import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj15903 {

    static long n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pq.add(Long.valueOf(st.nextToken()));
        }

        for(int i=0; i<m; i++){
            long one = pq.poll();
            long two = pq.poll();
            pq.add(one + two);
            pq.add(one + two);
        }

        long ret = 0;

        while(!pq.isEmpty()){
            ret += pq.poll();
        }

        System.out.println(ret);


    }

}
