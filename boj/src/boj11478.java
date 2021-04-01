import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class boj11478 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();


        Set<String> set = new HashSet<>();

        // 가장 크게 길이수만큼 돌리고
        for(int i=1; i<=str.length(); i++){ // 1,2,3,4,5
            for(int k=0; k<str.length()-i+1; k++){ // 5,4,3,2,1
                set.add(str.substring(k, k+i));
            }
        }

        System.out.println(set.size());

    }

}
