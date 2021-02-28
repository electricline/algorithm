import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Set<Integer> set = new LinkedHashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
            set.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(set.size());

    }

}
