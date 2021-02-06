import java.util.Arrays;
import java.util.Scanner;

public class boj2447 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];

        for(char[] ch : map){
            Arrays.fill(ch,' ');
        }

        recursion(0, 0, n, map);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void recursion(int r, int c, int num, char[][] map) {
        if(num == 1){
            map[r][c] = '*';
            return;
        }

        recursion(r,c, num/3, map);
        recursion(r+num/3,c, num/3, map);
        recursion(r+num/3*2,c, num/3, map);

        recursion(r, c+num/3, num/3, map);
        recursion(r+num/3*2, c+num/3, num/3, map);

        recursion(r,c+num/3*2, num/3, map);
        recursion(r+num/3,c+num/3*2, num/3, map);
        recursion(r+num/3*2,c+num/3*2, num/3, map);

    }

    public static void printStar(){

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i == 1 && j==1)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            if(i==2) continue;
            System.out.println();
        }

    }

}
