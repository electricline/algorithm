import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1826 {

    static int N;
    static List<pair> list = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new pair(a,b));
        }

        Collections.sort(list);

        st = new StringTokenizer(br.readLine());

        pair cur = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int ret = 0;
        int idx = 0;
        while(cur.fuel < cur.location){

            for(int i=idx; i<list.size(); i++){
                if(list.get(i).location <= cur.fuel){
                    pq.add(list.get(i).fuel);
                    idx = i;
                } else {
                    idx = i;
                    break;
                }
            }

            if(pq.size() == 0)
                break;

            ret++;
            cur.fuel += pq.poll();

        }

        if(cur.fuel < cur.location){
            System.out.println(-1);
        } else {
            System.out.println(ret);
        }


    }

    static class pair implements Comparable<pair>{
        int location;
        int fuel;

        pair(int location, int fuel){
            this.location = location;
            this.fuel = fuel;
        }

        @Override
        public int compareTo(pair o) {

            if(this.location - o.location > 0){
                return 1;
            } else {
                return -1;
            }


        }
    }
}
