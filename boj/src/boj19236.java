import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj19236 {

    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] dx = {0,-1,-1,-1,0,1,1,1};

    static int[][] fishMap = new int[4][4];
    static List<fish> fishList = new ArrayList<>();
    static int res = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        shark shark = new shark(0,0,0,0);

        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(i == 0 && j == 0){
                    fishList.add(new fish(i,j,a,b,-1));
                    shark.eat += a;
                    shark.dir = b-1;
                    shark.r = i;
                    shark.c = j;
                    fishMap[i][j] = -77; // 상어가 위치하면 -10
                    continue;
                }
                fishList.add(new fish(i,j,a,b-1,0));
                fishMap[i][j] = a;
            }
        }

        Collections.sort(fishList);

        dfs(fishMap, shark, fishList);


        System.out.println(res);

    }

    private static void dfs(int[][] fmap, shark shark, List<fish> fishList) {

        res = Math.max(res, shark.eat);

        movefish(fmap, fishList);

//        for(int i=0; i<4; i++){
//            for(int j=0; j<4; j++){
//                System.out.print(fmap[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("===============");

        // 상어 움직임
        for(int i=1; i<=3; i++){

            int nr = shark.r + dy[shark.dir] * i;
            int nc = shark.c + dx[shark.dir] * i;

            if(nr < 0 || nc < 0 || nr >= 4 || nc >= 4) continue;
            if(fmap[nr][nc] <= 0) continue; // 물고기 없는 칸

            int[][] tempMap = copyMap(fmap);
            List<fish> tempList = new ArrayList<>();
            copyList(fishList,tempList);

            tempMap[shark.r][shark.c] = 0;
            fish cur = tempList.get(fmap[nr][nc]-1);
            shark tempShark = new shark(cur.r, cur.c, cur.dir, shark.eat +cur.number);
            cur.alive = -1;
            tempMap[nr][nc] = -77;

            dfs(tempMap,  tempShark, tempList);

        }

    }

    private static void copyList(List<fish> fishList, List<fish> tempList) {

        for(int i=0; i<fishList.size(); i++){
            fish cur = fishList.get(i);
            fish next = new fish(cur.r,cur.c,cur.number,cur.dir,cur.alive);
            tempList.add(next);
        }
    }


    private static void movefish(int[][] fmap, List<fish> fishList) {
        // 물고기 움직이기. 16개의 물고
        for(int i=0; i<16; i++){

            // 물고기 꺼내기
            fish cur_fish = fishList.get(i);

            // 물고기 죽어있으면 스킵
            if(cur_fish.alive == -1) continue;

            // 물고기 방향 돌리기
            for(int dir=0; dir<8; dir++){
                int ndir = (dir + cur_fish.dir) % 8;
                int nr = cur_fish.r + dy[ndir];
                int nc = cur_fish.c + dx[ndir];


                if(nr < 0 || nc < 0 || nr >= 4 || nc >= 4) continue;
                if(fmap[nr][nc] < 0) continue;
//                System.out.println(cur_fish.r + "," + cur_fish.c + " " + nr + "," + nc);

                if(fmap[nr][nc] == 0){
                    fmap[cur_fish.r][cur_fish.c] = 0;
                    cur_fish.r = nr;
                    cur_fish.c = nc;
                } else {
                    int changeFishNum = fmap[nr][nc]-1; // 이 맵에 있는 물고기 번호 알아낸다. 리스트 인덱스 때문에 -1 처리
                    fish nextFish = fishList.get(changeFishNum); // 바꿀 물고기 얻기.
                    nextFish.r = cur_fish.r;
                    nextFish.c = cur_fish.c;
                    fmap[cur_fish.r][cur_fish.c] = nextFish.number;

                    cur_fish.r = nr;
                    cur_fish.c = nc;

                }
                fmap[nr][nc] = cur_fish.number;
                cur_fish.dir = ndir;
                break;
            }

        }

    }

    private static int[][] copyMap(int[][] map){
        int[][] tempMap = new int[4][4];

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                tempMap[i][j] = map[i][j];
            }
        }

        return tempMap;
    }

    static class shark {

        int r;
        int c;
        int dir;
        int eat;

        shark(int r, int c, int dir, int eat){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.eat = eat;
        }

    }

    static class fish implements Comparable<fish>{
        int r;
        int c;
        int number;
        int dir;
        int alive;

        fish(int r, int c, int number, int dir, int alive){
            this.r = r;
            this.c = c;
            this.number = number;
            this.dir = dir;
            this.alive = alive;
        }

        @Override
        public int compareTo(fish o) {
            if(this.number > o.number){
                return 1;
            } else {
                return -1;
            }
        }
    }

}
