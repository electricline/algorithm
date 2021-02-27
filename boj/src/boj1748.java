import java.util.Scanner;

public class boj1748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;

        // 1~ 10 -> 9개
        // 10 ~ 100 -> 90 * 2
        // 100 ~ 1000 -> 900 * 3
        int start = 1;
        int end = 10;
        int num = 1;
        while(true){
            for(int i=start; i<end; i++){
                res += num;
                if(i == n){
                    System.out.println(res);
                    return;
                }
            }
            start *= 10;
            end *= 10;
            num++;
        }

    }

}
