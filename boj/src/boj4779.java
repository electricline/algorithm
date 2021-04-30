import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj4779 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while((input = br.readLine()) != null){

            int num = Integer.parseInt(input);
            num = (int) Math.pow(3, num);

            sb = new StringBuilder();

            recur(num);

            System.out.println(sb);

        }
    }

    private static void recur(int depth) {
        if(depth == 1){
            sb.append("-");
            return;
        }


        recur(depth/3);
        for(int i=0; i<depth/3; i++){
            sb.append(" ");
        }
        recur(depth/3);

    }
}
