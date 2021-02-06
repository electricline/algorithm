import java.util.Scanner;

public class boj11729 {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi(1,2,3, n);

        System.out.println(cnt);
        System.out.println(sb);

    }

    private static void hanoi(int start, int via, int end, int n) {
        cnt++;
        if(n == 1){
            sb.append(start + " " + end + "\n");
            return;
        }

        hanoi(start, end, via, n-1);
        // move
        sb.append(start + " " + end + "\n");
        hanoi(via,start,end, n-1);

    }

}
