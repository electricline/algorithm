import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj20056 {
    static int n, m, k;
    static int[][] map;
    static int[][] tempMap;
    static Map<Integer, List<fireball>> fireballTempMap;
    static Map<Integer, List<fireball>> fireballMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            String row = Integer.toString(r);
            String col = Integer.toString(c);

            map[r][c] += 1;
            if(!fireballMap.containsKey(Integer.parseInt(row+col))){
                fireballMap.put(Integer.valueOf(row+col), new ArrayList<>());
            }
            fireballMap.get(Integer.parseInt(row+col)).add(new fireball(r,c,m,s,d));
        }

        // k번 이동 후 종료
        while(k-- > 0) {
            fireballMove();
            moreThanTwo();
        }

        int res = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j]>=1){
                    String temp = Integer.toString(i);
                    String temp2 = Integer.toString(j);
                    String key = temp+temp2;
                    List<fireball> list = fireballMap.get(Integer.parseInt(key));

                    for(fireball f: list){
                        res += f.m;
                    }
                }
            }
        }

        System.out.println(res);

    }

    private static void moreThanTwo() {

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j] >= 2){
                    sum(i,j);
                }
            }
        }


    }

    private static void sum(int row, int col) {

        String r = Integer.toString(row); String c = Integer.toString(col);
        String key = r+c;
        List<fireball> list = fireballMap.get(Integer.parseInt(key));

        int cur_m = 0;
        int cur_s = 0;
        boolean odd = false;
        boolean even = false;
        for(int i=0; i<list.size(); i++){
            cur_m += list.get(i).m;
            cur_s += list.get(i).s;
            if(list.get(i).d % 2 == 0){
                even = true;
            } else {
                odd = true;
            }
        }
        List<fireball> tempList = new ArrayList<>();
        cur_m = cur_m/5;
        cur_s = cur_s/map[row][col];
        if(cur_m == 0){
            map[row][col] = 0;
            fireballMap.put(Integer.valueOf(key), tempList);
            return;
        }
        if(odd && even){
            tempList.add(new fireball(row,col,cur_m,cur_s,1));
            tempList.add(new fireball(row,col,cur_m,cur_s,3));
            tempList.add(new fireball(row,col,cur_m,cur_s,5));
            tempList.add(new fireball(row,col,cur_m,cur_s,7));
        } else {
            tempList.add(new fireball(row,col,cur_m,cur_s,0));
            tempList.add(new fireball(row,col,cur_m,cur_s,2));
            tempList.add(new fireball(row,col,cur_m,cur_s,4));
            tempList.add(new fireball(row,col,cur_m,cur_s,6));
        }
        map[row][col] = 4;
        fireballMap.put(Integer.valueOf(key), tempList);

    }

    private static void fireballMove() {

        tempMap = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                tempMap[i][j] = 0;
            }
        }
        fireballTempMap = new HashMap<>();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j] >= 1){
                    move(i,j);
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j] = tempMap[i][j];
            }
        }

        fireballMap = fireballTempMap;


    }

    private static void move(int row, int col) {

        String r = Integer.toString(row); String c = Integer.toString(col);
        String key = r+c;
        List<fireball> list = fireballMap.get(Integer.parseInt(key));

        // 새로운 map에다 넣어야 되네 ..
        for(int i=0; i<list.size(); i++){
            direction(list.get(i));
        }

    }

    private static void direction(fireball cur_fire) {
        int cur_r = cur_fire.r;
        int cur_c = cur_fire.c;
        int move_num;
        if(cur_fire.s > n){
            move_num = cur_fire.s/n;
        } else {
            move_num = cur_fire.s;
        }

        if(cur_fire.d == 0){
            for(int i=0; i<move_num; i++){
                cur_r--;
                if(cur_r == 0)
                    cur_r = n;
            }
        } else if(cur_fire.d == 1){
            for(int i=0; i<move_num; i++){
                cur_r--;
                cur_c++;
                if(cur_r < 1){
                    cur_r = n;
                }
                if(cur_c>n){
                    cur_c = 1;
                }
            }
        } else if(cur_fire.d == 2){
            for(int i=0; i<move_num; i++){
                cur_c++;
                if(cur_c>n){
                    cur_c = 1;
                }
            }
        } else if(cur_fire.d == 3){
            for(int i=0; i<move_num; i++){
                cur_r++;
                cur_c++;
                if(cur_r > n || cur_c > n){
                    if(cur_r > n)
                        cur_r -=n;
                    if(cur_c > n)
                        cur_c -=n;
                }
            }
        } else if(cur_fire.d == 4){
            for(int i=0; i<move_num; i++){
                cur_r++;
                if(cur_r > n){
                    cur_r = 1;
                }
            }
        } else if(cur_fire.d == 5){
            for(int i=0; i<move_num; i++){
                cur_r++;
                cur_c--;
                if(cur_r > n || cur_c < 1){
                    if(cur_r > n)
                        cur_r = 1;
                    if(cur_c < 1)
                        cur_c = n;
                }
            }
        } else if(cur_fire.d == 6){
            for(int i=0; i<move_num; i++){
                cur_c--;
                if(cur_c < 1)
                    cur_c = n;
            }
        } else if(cur_fire.d == 7){
            for(int i=0; i<move_num; i++){
                cur_r--;
                cur_c--;
                if(cur_r < 1)
                    cur_r = n;
                if(cur_c < 1)
                    cur_c = n;
            }
        }


        tempMap[cur_r][cur_c] += 1;
        String row = Integer.toString(cur_r);
        String col = Integer.toString(cur_c);
        if(!fireballTempMap.containsKey(Integer.parseInt(row+col))){
            fireballTempMap.put(Integer.valueOf(row+col), new ArrayList<>());
        }
        fireballTempMap.get(Integer.parseInt(row+col)).add(new fireball(cur_r,cur_c,cur_fire.m, cur_fire.s, cur_fire.d));
    }

    private static class fireball {

        int r;
        int c;
        int m;
        int s;
        int d;

        fireball(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

    }

}
