import java.util.Scanner;

public class boj1476 {

    public static void main(String[] args) {
        int e, s, m;

        Scanner sc = new Scanner(System.in);

        e = sc.nextInt(); s = sc.nextInt(); m = sc.nextInt();
        int year = 1;
        while(true){
            if ((year - e) % 15 == 0 && (year - s) % 28 == 0 && (year - m) % 19 == 0)
            {
                System.out.println(year);
                return;
            }
            year++;

        }

    }
}
