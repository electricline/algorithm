import java.util.Scanner;

public class boj10870 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(fibo(N));
    }

    private static int fibo(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        return fibo(n-1) + fibo(n-2);
    }
}
