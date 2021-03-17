import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10211 {

    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[k];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<k; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }


            int res = arr[0];
            int max = arr[0];
            for(int j=1; j<k; j++){
                max = Math.max(max + arr[j], arr[j]);
                res = Math.max(res, max);
            }

            sb.append(res).append('\n');

        }

        System.out.println(sb);

    }
}
