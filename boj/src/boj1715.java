import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(Integer.valueOf(br.readLine()));
        }
        int sum = 0;
        int res = 0;


        while(!pq.isEmpty()){

            if(pq.size() == 1){
                break;
            }
            sum = pq.poll();
            sum += pq.poll();
            res += sum;
            pq.add(sum);
        }

        System.out.println(res);
    }
}
