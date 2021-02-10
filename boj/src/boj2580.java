
import java.util.*;

public class boj2580 {

    public static void main(String[] args) {

        int[][] map = new int[9][9];
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        find(map,0,0);
    }

    private static void find(int[][] map, int r, int c) {
//        System.out.println("r " + r + " c " + c);
        if(c == 9){
            find(map, r+1, 0);
            return;
        }

        if(r == 9){
            printMap(map);
            System.exit(0);
        }

        if(map[r][c] == 0) {
            for (int i = 1; i < 10; i++) {
                if (checkNumber(map, r, c, i)) {
                    map[r][c] = i;
                    find(map, r, c+1);
                    map[r][c] = 0;
                }
            }
            return ;
        }
        find(map, r, c+1);
    }


    private static boolean checkNumber(int[][] arr, int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) {
                return false;
            }
        }

        int set_row = ((row) / 3) * 3; //
        int set_col = ((col) / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }


    private static void printMap(int[][] res) {

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

}
