import java.util.Scanner;

public class boj1978 {
    static boolean[] sosu = new boolean[1002];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=2; i<=1001; i++){
            sosu[i] = true;
        }

        // 에라토네스의 체
        for(int i=2; i*i<=1001; i++){
            for(int j=i*i; j<=1001; j+=i){
                sosu[j] = false;
            }
        }

        int res = 0;
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(sosu[num])
                res++;
        }

        System.out.println(res);

    }
}
