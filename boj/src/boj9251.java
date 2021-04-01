import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9251 {

    static int[][] lcs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charsA = br.readLine().toCharArray();
        char[] charsB = br.readLine().toCharArray();

        lcs = new int[charsA.length+1][charsB.length+1];
        int res = -1;
        for(int i=1; i<=charsA.length; i++){

            for(int j=1; j<=charsB.length; j++){

                if(charsA[i-1] == charsB[j-1]){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j] , lcs[i][j-1]);
                }
                res = Math.max(lcs[i][j], res);
            }

        }

        System.out.println(res);

    }

}
