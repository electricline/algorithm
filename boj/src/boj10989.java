import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] counting = new int[10001];

        // 1. counting input
        for(int i=0; i<n; i++){
            int input = Integer.parseInt(br.readLine());
            counting[input]++;
        }

        // 2. print
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<10001; i++){
            for(int j=0; j<counting[i]; j++){
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);




    }

}
