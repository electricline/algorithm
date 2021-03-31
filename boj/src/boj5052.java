import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            boolean flag = false;

            for(int j=0; j<n; j++){
                arr[j] = br.readLine();
            }

            Arrays.sort(arr);

            for(int j=0; j<n-1; j++){
                if(arr[j+1].startsWith(arr[j])){
                    flag = true;
                    break;
                }
            }


            if(!flag) // false
                sb.append("YES").append('\n');
            else
                sb.append("NO").append('\n');

        }

        System.out.println(sb.toString());

    }

}
