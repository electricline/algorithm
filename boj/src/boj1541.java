import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");

        int res = 0;
        for(int i=0; i<input.length; i++){
            if(i == 0){
                res += calc(input[i]);
            } else {
                res -= calc(input[i]);
            }
        }

        System.out.println(res);

    }

    private static int calc(String input) {

        String[] temp = input.split("\\+");

        int sum = 0;
        for(String num : temp){
            sum += Integer.parseInt(num);
        }
        return sum;
    }

}
