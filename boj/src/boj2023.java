import java.util.Scanner;

public class boj2023 {

    static boolean[] sosu;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 1;

        for(int i=1; i<=n; i++){
            num *= 10;
        }

        makeSosuArray(num);
        for(int i=num/10; i<num; i++){
            if(sosu[i]){
                dfs(String.valueOf(i), n);
            }
        }

        System.out.println(sb);

    }

    private static void dfs(String str, int n) {
        if(n == 1){
            sb.append(str).append('\n');
            return;
        }

        int temp = Integer.parseInt(str.substring(0, n-1));
        if(sosu[temp]){
            dfs(str, n-1);
        }

    }

    public static void makeSosuArray(int num){

        sosu = new boolean[num+1];

        for(int i=2; i<num; i++){
            sosu[i] = true;
        }

        for(int i=2; i*i<num+1; i++){
            for(int j=i*i; j<num+1; j+=i){
                sosu[j] = false;
            }
        }
    }

}
