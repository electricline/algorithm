import java.util.Scanner;

public class boj1629 {
    static int a, b, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        System.out.println(recursion(a,b));
    }

    private static long recursion(int num, int depth) {

        if(depth == 0) return 1;
        if(depth == 1) return num % c;

        if(depth%2 == 0){
            long temp = recursion(num, depth/2);
            return (temp * temp) % c;
        } else {
            long temp = recursion(num,  depth-1);
            return (temp * num) % c;
        }


    }
}
