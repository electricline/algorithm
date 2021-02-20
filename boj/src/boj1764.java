import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList();
        for(int i=0; i<m; i++){
            String temp = br.readLine();
            if(set.contains(temp)){
                list.add(temp);
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }

}
