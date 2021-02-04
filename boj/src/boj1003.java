import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj1003 {

    static int[] zero = new int[41];
    static int[] one = new int[41];

    public static void main(String[] args) throws IOException {
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int[] zero = new int[41];
        int[] one = new int[41];

        findFibo();

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            findRes(n);
        }

    }

    private static void findFibo(){

        zero[0] = 1; one[0] = 0;
        zero[1] = 0; one[1] = 1;

        for(int i=2; i<41; i++){
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }

    }

    private static void findRes(int n) {
        System.out.println(zero[n] + " " + one[n]);
    }

}
