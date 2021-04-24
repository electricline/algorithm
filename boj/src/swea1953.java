import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution11
{
    static int n, m, manhole_r, manhole_c, L;
    static int[][] map;
    static boolean[][] visitied;
    static Queue<person> q;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int ret;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
            manhole_r = Integer.parseInt(st.nextToken()); manhole_c = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            visitied = new boolean[n][m];
            map = new int[n][m];
            ret = 0;
            q = new LinkedList<>();

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//            if(test_case != 2) continue;
            solve();


            System.out.println("#" + test_case + " " +ret);

        }
    }

    private static void solve() {
        q.add(new person(manhole_r, manhole_c, map[manhole_r][manhole_c]));
        visitied[manhole_r][manhole_c] = true;
        ret++;
        int time = 1;
        L--;
        while(L-->0){
//            System.out.println("time " + time++);
            int qs = q.size();

            for(int i=0; i<qs; i++){

                person cur = q.poll();
//                System.out.println(cur.r +"," + cur.c +"," +cur.tunnel);
                for(int dir=0; dir<4; dir++){

                    int nr = cur.r + dy[dir];
                    int nc = cur.c + dx[dir];
//                    System.out.println("NEXT before " + nr + "," + nc);
                    if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                    if(visitied[nr][nc]) continue;
                    if(map[nr][nc] == 0) continue;
//                    System.out.println("NEXT after " + nr + "," + nc);
                    if(dir == 0){ //위
                        if(cur.tunnel == 1 || cur.tunnel == 2 || cur.tunnel == 4 || cur.tunnel == 7){
                            if(map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6){
//                                System.out.println("D");
                                visitied[nr][nc] = true;
                                q.add(new person(nr,nc,map[nr][nc]));
                                ret++;
                            }
                        }
                    } else if(dir == 1){ // 아
                        if(cur.tunnel == 1 | cur.tunnel == 2 || cur.tunnel == 5 || cur.tunnel == 6){
                            if(map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7){
//                                System.out.println("D");
                                visitied[nr][nc] = true;
                                q.add(new person(nr,nc,map[nr][nc]));
                                ret++;
                            }
                        }
                    } else if(dir == 2){ // 왼쪽
                        if(cur.tunnel == 1 || cur.tunnel == 3 || cur.tunnel == 6 || cur.tunnel == 7){
                            if(map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5){
//                                System.out.println("D");
                                visitied[nr][nc] = true;
                                q.add(new person(nr,nc,map[nr][nc]));
                                ret++;
                            }
                        }
                    } else { // 오
                        if(cur.tunnel == 1 || cur.tunnel == 3 || cur.tunnel == 4 || cur.tunnel == 5){
                            if(map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7){
//                                System.out.println("D");
                                visitied[nr][nc] = true;
                                q.add(new person(nr,nc,map[nr][nc]));
                                ret++;
                            }
                        }
                    }

                }
            }

        }


    }

    static class person {
        int r;
        int c;
        int tunnel;

        person(int r, int c, int tunnel){
            this.r = r;
            this.c = c;
            this.tunnel = tunnel;
        }
    }
}