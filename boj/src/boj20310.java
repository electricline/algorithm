import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj20310 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int zero = 0;
        int one = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '0'){
                zero++;
            } else {
                one++;
            }
        }

        StringBuilder sb = new StringBuilder();

        int zeroCnt = 0;
        int oneCnt = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '0' && zeroCnt != zero/2){
                sb.append(0);
                zeroCnt++;
            } else if(str.charAt(i) == '1' && oneCnt == one/2){
                sb.append(1);
            } else if(str.charAt(i) == '1' && oneCnt != one/2){
                oneCnt++;
            }
        }

        System.out.println(sb);

    }

}
