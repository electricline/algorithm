import java.util.Scanner;

public class boj2231 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=1000000; i++){
            String temp = String.valueOf(i);
            int sum = 0;
            sum += i;
            for(int j=0; j<temp.length(); j++){
                sum += Character.getNumericValue(temp.charAt(j));
            }
            if(sum == n){
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);

    }

}
