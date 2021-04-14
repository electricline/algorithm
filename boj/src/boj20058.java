import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj20058 {

    static int n, q, L=0;
    static int[][] map;
    static int[][] temp;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visitied;
    static int res = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        n = (int) Math.pow(2,n);
        map = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        st = new StringTokenizer(br.readLine());
        while(q-- >0){
            L = Integer.parseInt(st.nextToken());
            fireStrom();
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sum += map[i][j];
            }
        }
        System.out.println(sum);

        visitied = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visitied[i][j]) continue;
                if(map[i][j] == 0)continue;
                bfs(i,j);
            }
        }

        System.out.println(res);

    }

    private static void bfs(int i, int j) {

        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        visitied[i][j] = true;
        int iceSum = 0;
        while(!q.isEmpty()){

            int cur_r = q.poll();
            int cur_c = q.poll();


            iceSum += 1;

            for(int dir=0; dir<4; dir++) {
                int nr = cur_r + dy[dir];
                int nc = cur_c + dx[dir];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if(visitied[nr][nc]) continue;
                if(map[nr][nc] == 0) continue;
                q.add(nr);
                q.add(nc);
                visitied[nr][nc] = true;
            }

        }

        res = Math.max(iceSum, res);



    }

    private static void fireStrom() {

        L = (int) Math.pow(2,L);

        temp = new int[map.length][map.length];

        for(int i=0; i<n; i+=L){
            for(int j=0; j<n; j+=L){
                rotate(i,j);
            }
        }

        map = temp;

        temp = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = map[i][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int cnt = 0;
                for(int dir=0; dir<4; dir++){
                    int nr = i + dy[dir];
                    int nc = j + dx[dir];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n){
                        continue;
                    }
                    if(temp[nr][nc] > 0)
                        cnt++;
                }
                if(cnt < 3){
                    if(map[i][j] <= 0) continue;
                    map[i][j] -= 1;
                }

            }
        }



    }

    private static void rotate(int sr, int sc) {

        int idx = sc;
        for(int i=sr; i<sr+L; i++){
            int idx2 = sr+L-1;
            for(int j=sc; j<sc+L; j++){
                temp[i][j] = map[idx2--][idx];
            }
            idx++;
        }


    }
}
