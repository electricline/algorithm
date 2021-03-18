import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16469 {

    static int r, c;
    static int[][] map;
    static int a_r, a_c, b_r, b_c, c_r, c_c;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int min = Integer.MAX_VALUE;
    static int res = -1;
    static int[][][] visitied;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        map = new int[r + 1][c + 1];
        visitied = new int[r + 1][c + 1][3];



        for (int i = 1; i <= r; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }

        for(int[][] first : visitied){
            for(int[] second : first){
                Arrays.fill(second, - 1);
            }
        }


        st = new StringTokenizer(br.readLine());
        a_r = Integer.parseInt(st.nextToken());
        a_c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        b_r = Integer.parseInt(st.nextToken());
        b_c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        c_r = Integer.parseInt(st.nextToken());
        c_c = Integer.parseInt(st.nextToken());


        for(int i=0; i<3; i++){
            solve(i);
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if(visitied[i][j][0] != -1 && visitied[i][j][1] != -1 && visitied[i][j][2] != -1 && map[i][j] == 0){
                    int temp = Math.max(visitied[i][j][0], visitied[i][j][1]);
                    temp = Math.max(temp,visitied[i][j][2]);
                    if(temp == -1) continue;
                    if(min > temp){
                        min = temp;
                        res = 1;
                    } else if(min == temp){
                        res++;
                    }
                }
            }
        }


        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(min);
            System.out.println(res);
        }

    }

    private static void solve(int idx) {

        Queue<pair> q = new LinkedList<>();

        if(idx == 0){
            q.add(new pair(a_r, a_c, 0,0));
        } else if(idx == 1){
            q.add(new pair(b_r, b_c, 1,0));
        } else {
            q.add(new pair(c_r, c_c, 2,0));
        }


        visitied[a_r][a_c][0] = 0;
        visitied[b_r][b_c][1] = 0;
        visitied[c_r][c_c][2] = 0;


        while (!q.isEmpty()) {

            pair cur = q.poll();
//            System.out.println(cur.r + " " + cur.c);

            for(int i=0; i<4; i++){

                int nr = cur.r + dy[i];
                int nc = cur.c + dx[i];

                if(nr >=1 && nr <= r && nc >= 1 && nc <= c && map[nr][nc] == 0 && visitied[nr][nc][cur.number] == -1){
                    visitied[nr][nc][cur.number] = cur.score + 1;
                    q.add(new pair(nr, nc, cur.number, cur.score+1));
                }

            }

        }

    }


    static class pair {
        int r;
        int c;
        int number;
        int score;

        pair(int r, int c, int number, int score) {
            this.r = r;
            this.c = c;
            this.number = number;
            this.score = score;
        }
    }

}
