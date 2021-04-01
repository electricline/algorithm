import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9252 {

    static int[][] lcs;
    static char[][] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charsA = br.readLine().toCharArray();
        char[] charsB = br.readLine().toCharArray();
        String temp;

        lcs = new int[charsA.length+1][charsB.length+1];
        chars = new char[charsA.length+1][charsB.length+1];
        int res = -1;
        for(int i=1; i<=charsA.length; i++){

            for(int j=1; j<=charsB.length; j++){

                if(charsA[i-1] == charsB[j-1]){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                    chars[i][j] = 'D'; // 대각
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j] , lcs[i][j-1]);

                    if(lcs[i][j] == lcs[i-1][j]){
                        chars[i][j] = 'T'; // top
                    } else {
                        chars[i][j] = 'L'; // left
                    }

                }
                res = Math.max(lcs[i][j], res);
            }

        }

        int r = charsA.length;
        int c = charsB.length;

        StringBuilder sb = new StringBuilder();

        while(r != 0 && c != 0){

            if(chars[r][c] == 'D'){
                sb.append(charsA[r-1]);
                r--;
                c--;
            } else if(chars[r][c] == 'T'){
                r--;
            } else if(chars[r][c] == 'L'){
                c--;
            }

        }


        System.out.println(res);

        if(res != 0){
            System.out.println(sb.reverse());
        }

    }

}
