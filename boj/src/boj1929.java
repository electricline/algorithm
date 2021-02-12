import java.util.Scanner;

public class boj1929 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); int n = sc.nextInt();

        boolean[] sosu = new boolean[n+1];

        for(int i=2; i<n+1; i++){
            sosu[i] = true;
        }

        for(int i=2; i*i<n+1; i++){
            for(int j=i*i; j<n+1; j+=i){
                sosu[j] = false;
            }
        }

        for(int i=m; i<n+1; i++){
            if(sosu[i])
                System.out.println(i);
        }

    }

}
