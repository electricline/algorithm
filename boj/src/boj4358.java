import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class boj4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        double treeNums = 0;
        while(true){

            String treeName = br.readLine();
            if(treeName == null || treeName.length() == 0)
                break;

            map.put(treeName, map.getOrDefault(treeName, 0) + 1);
            treeNums++;
        }

        PriorityQueue<String> pq = new PriorityQueue();
        for(String key  : map.keySet()){
            pq.add(key);
        }

        while(!pq.isEmpty()){

            String name = pq.poll();
            String ratios = String.format("%.4f", map.get(name) * 100 / treeNums);
            sb.append(name).append(" ").append(ratios).append('\n');

        }

        System.out.println(sb);

    }

}
