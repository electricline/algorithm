import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj20920 {

    static int n, m;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<str> list = new ArrayList<>();
        int listIdx = 0;
        for(int i=0; i<n;i++){
            String name = br.readLine();
            if(name.length() < m) continue;
            if(!map.containsKey(name)){
                map.put(name, listIdx);
                list.add(new str(name, listIdx++, 1));
            } else {
                int temp = map.get(name);
                list.get(temp).cnt += 1;
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i).name).append("\n");
        }

        System.out.println(sb);

    }

    public static class str implements Comparable<str> {
        String name;
        int idx;
        int cnt;

        public str(String name, int idx, int cnt) {
            this.name = name;
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(str o) {
            if(this.cnt - o.cnt > 0){
                return -1;
            } else if(this.cnt == o.cnt) {
                if(o.name.length() - this.name.length() > 0){
                    return 1;
                } else if(this.name.length() == o.name.length()){
                    return this.name.compareTo(o.name);
                } else{
                    return -1;
                }
            } else {
                return 1;
            }

        }
    }

}
