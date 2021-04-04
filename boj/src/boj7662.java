import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj7662 {

    static int T,k;
    static StringBuilder sb = new StringBuilder();
    static TreeMap<Long, Long> treeMap;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){

            k = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();
            for(int j=0; j<k; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                long num = Long.parseLong(st.nextToken());
                if(command == 'I'){
                    treeMap.put(num, treeMap.getOrDefault(num, 0L) + 1);
                } else if(!treeMap.isEmpty() && command == 'D' && num == 1){
                    long key = treeMap.lastKey();
                    treeMap.put(key, treeMap.get(key)-1);
                    if(treeMap.get(key) <= 0)
                        treeMap.remove(key);
                } else if(!treeMap.isEmpty() && command == 'D' && num == -1){
                    long key = treeMap.firstKey();
                    treeMap.put(key, treeMap.get(key)-1);
                    if(treeMap.get(key) <= 0)
                        treeMap.remove(key);
                }
            }

            if(treeMap.isEmpty())
                sb.append("EMPTY").append('\n');
            else {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append('\n');
            }



        }

        System.out.println(sb);

    }

}
