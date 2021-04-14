import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14499 {

    static int n, m, dice_r, dice_c , k;
    static int[][] map;
    static int[] moveDir;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dice_r = Integer.parseInt(st.nextToken());
        dice_c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        moveDir = new int[k];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            moveDir[i] = Integer.parseInt(st.nextToken());
        }

        dice DICE = new dice(dice_r, dice_c,0,0,0,0,0,0);

        for(int i=0; i<moveDir.length; i++){

            int a = DICE.one;
            int b = DICE.two;
            int c = DICE.three;
            int d = DICE.four;
            int e = DICE.five;
            int f = DICE.six;

            if(moveDir[i] == 1){ // 동
                int next_r = DICE.cur_r;
                int next_c = DICE.cur_c + 1;
                if(!check(next_r, next_c)) continue;
                DICE.cur_r = next_r;
                DICE.cur_c = next_c;

                DICE.one = c;
                DICE.two = b;
                DICE.three = f;
                DICE.four = a;
                DICE.five = e;
                DICE.six = d;

            } else if(moveDir[i] == 2){ // 서
                int next_r = DICE.cur_r;
                int next_c = DICE.cur_c - 1;
                if(!check(next_r, next_c)) continue;
                DICE.cur_r = next_r;
                DICE.cur_c = next_c;

                DICE.one = d;
                DICE.two = b;
                DICE.three = a;
                DICE.four = f;
                DICE.five = e;
                DICE.six = c;


            } else if(moveDir[i] == 3){ // 북
                int next_r = DICE.cur_r - 1;
                int next_c = DICE.cur_c;
                if(!check(next_r, next_c)) continue;
                DICE.cur_r = next_r;
                DICE.cur_c = next_c;

                DICE.one = b;
                DICE.two = f;
                DICE.three = c;
                DICE.four = d;
                DICE.five = a;
                DICE.six = e;

            } else { //
                int next_r = DICE.cur_r + 1;
                int next_c = DICE.cur_c;
                if(!check(next_r, next_c)) continue;
                DICE.cur_r = next_r;
                DICE.cur_c = next_c;

                DICE.one = e;
                DICE.two = a;
                DICE.three = c;
                DICE.four = d;
                DICE.five = f;
                DICE.six = b;

            }


            if(map[DICE.cur_r][DICE.cur_c] == 0){
                map[DICE.cur_r][DICE.cur_c] = DICE.one;
            } else {
                DICE.one = map[DICE.cur_r][DICE.cur_c];
                map[DICE.cur_r][DICE.cur_c] = 0;
            }

            System.out.println(DICE.six);
        }

    }

    private static boolean check(int next_r, int next_c) {

        if(next_r < 0 || next_c < 0 || next_r >= n || next_c >= m) return false;

        return true;
    }

    public static class dice {
        int cur_r;
        int cur_c;
        int one;
        int two;
        int three;
        int four;
        int five;
        int six;

        dice(int cur_r, int cur_c, int one, int two, int three, int four, int five, int six){
            this.cur_r = cur_r;
            this.cur_c = cur_c;
            this.one = one;
            this.two = two;
            this.three = three;
            this.four = four;
            this.five = five;
            this.six = six;
        }
    }

}
