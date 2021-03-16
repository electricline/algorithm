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
    static int[][][] visiteid;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        map = new int[r + 1][c + 1];
        visiteid = new int[r + 1][c + 1][3];



        for (int i = 1; i <= r; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }

        for(int[][] first :  visiteid){
            for(int[] second : first){
                Arrays.fill(second,0);
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



        solve();


        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {

                if(visiteid[i][j][0] != 0 && visiteid[i][j][1] != 0 && visiteid[i][j][2] != 0){

                    int temp = Math.max(visiteid[i][j][0], visiteid[i][j][1]);
                    temp = Math.max(temp,visiteid[i][j][2]);

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

    private static void solve() {

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(a_r, a_c, 0));
        q.add(new pair(b_r, b_c, 1));
        q.add(new pair(c_r, c_c, 2));

        while (!q.isEmpty()) {

            pair cur = q.poll();

            for (int i = 0; i < 4; i++) {

                int nr = cur.r + dy[i];
                int nc = cur.c + dx[i];
                if(nr < 1 || nr > r || nc < 1 || nc > c) continue;
                if(map[nr][nc] == 1) continue;
                if(visiteid[nr][nc][cur.number] != 0) continue;
                visiteid[nr][nc][cur.number] = visiteid[cur.r][cur.c][cur.number] + 1;
                q.add(new pair(nr, nc, cur.number));
            }
        }

    }


    static class pair {
        int r;
        int c;
        int number;

        pair(int r, int c, int number) {
            this.r = r;
            this.c = c;
            this.number = number;
        }
    }

}
