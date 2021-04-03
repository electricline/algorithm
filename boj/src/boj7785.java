import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj7785 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0 ;i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String method = st.nextToken();

            if(method.equals("enter")){
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>();
        for(String name : set){
            list.add(name);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb);


    }

}
