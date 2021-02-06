import java.util.Scanner;

public class boj10872 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

    }

    private static int fibo(int n) {
        if(n == 0 || n == 1) return 1;
        return n * fibo(n-1);
    }

}
