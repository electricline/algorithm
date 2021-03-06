import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj20056 {

    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int n, m, k;
    static int[][] fireBall;
    static ArrayList<fire>[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new ArrayList[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j] = new ArrayList<>();
            }
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c].add(new fire(r,c,m,s,d));
        }

        while(k-- >0){
            move();
            findTwoMoreFire();
        }

        int res = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j].size() == 0) continue;
                for(fire f : map[i][j]){
                    res += f.m;
                }
            }
        }

        System.out.println(res);

    }

    private static void findTwoMoreFire() {

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j].size() < 2) continue;

                int sum_m = 0;
                int sum_s = 0;
                int odd = 0;
                int even = 0;
                for(fire f : map[i][j]){
                    sum_m += f.m;
                    sum_s += f.s;
                    if(f.d % 2 == 0) even++;
                    else odd++;
                }

                sum_m = sum_m/5;
                sum_s /= map[i][j].size();
                map[i][j].clear();

                if(sum_m != 0){

                    if(even == 0 || odd == 0){
                        map[i][j].add(new fire(i,j, sum_m, sum_s, 0));
                        map[i][j].add(new fire(i,j, sum_m, sum_s, 2));
                        map[i][j].add(new fire(i,j, sum_m, sum_s, 4));
                        map[i][j].add(new fire(i,j, sum_m, sum_s, 6));
                    } else {
                        map[i][j].add(new fire(i,j, sum_m, sum_s, 1));
                        map[i][j].add(new fire(i,j, sum_m, sum_s, 3));
                        map[i][j].add(new fire(i,j, sum_m, sum_s, 5));
                        map[i][j].add(new fire(i,j, sum_m, sum_s, 7));
                    }


                }


            }
        }

    }

    private static void move() {

        List<fire> temp = new ArrayList<>();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j].size() == 0) continue;
                List<fire> fires = map[i][j];
                for(fire f : fires){

                    int nr = f.r + dy[f.d]*f.s % n;
                    int nc = f.c + dx[f.d]*f.s % n;

                    if(nr > n) {
                        nr = nr % n;
                    }
                    else if(nr < 1) {
                        nr = n - (Math.abs(nr) % n);
                    }

                    if(nc > n) {
                        nc = nc % n;
                    }
                    else if(nc < 1) {
                        nc = n - (Math.abs(nc) % n);
                    }


                    temp.add(new fire(nr,nc,f.m,f.s,f.d));
                }
                map[i][j].clear();
            }
        }

        for(fire f : temp){
            map[f.r][f.c].add(f);
        }

    }

    static class fire {
        int r;
        int c;
        int m;
        int s;
        int d;

        fire(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

    }




}
