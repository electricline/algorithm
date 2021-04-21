import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution8
{
    static int m, bc;
    static int[] move_a;
    static int[] move_b;
    static List<battery> batteryList;
    static int[] dy = {0,-1,0,1,0}; // 무 상 우 하 좌
    static int[] dx = {0,0,1,0,-1};
    static boolean[] visitied;
    static int[] sum_max;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T= Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); bc = Integer.parseInt(st.nextToken());
            move_a = new int[m+2]; move_b = new int[m+2];
            batteryList = new ArrayList<>();
            visitied = new boolean[bc];
            sum_max = new int[m+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=m; i++){
                move_a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=m; i++){
                move_b[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<bc; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                batteryList.add(new battery(c,r,range,power));
            }

            solve();

            int ret = 0;
            for(int i=0; i<sum_max.length; i++){
                ret += sum_max[i];
//                System.out.print(sum_max[i] + " ");
            }

            System.out.println("#"+test_case+" " +ret);

        }
    }

    private static void solve() {

        int time = 0;
        person gitae = new person(1,1,0);
        person harden = new person(10,10,0);



        // 시간만큼 이동 시킨다. 0초부터 시
        while(time <= m){

            // 위치에서의 최종 합 구하기
            dfs(0, new ArrayList<>(), gitae, harden, time);

//
//            System.out.println("TIME " + time + " first person " + "[" + gitae.r + "," + gitae.c + "]");
//            System.out.println("TIME " + time + " second person " + "[" + harden.r + "," + harden.c + "]");

            time++;

            // 위치 이동
            int dir_a = move_a[time];
            int dir_b = move_b[time];

            move_person(dir_a, gitae);
            move_person(dir_b, harden);


        }

    }

    private static void dfs(int depth, List<Integer> list, person gitae, person harden, int time) {

        if(depth == 2){

            int a_idx = list.get(0);
            int b_idx = list.get(1);
            battery a_battery = batteryList.get(a_idx);
            battery b_battery = batteryList.get(b_idx);

            if(isPossible(a_battery, gitae)){
                gitae.sum = a_battery.power;
            } else {
                gitae.sum = 0;
            }

            if(isPossible(b_battery, harden)){
                harden.sum = b_battery.power;
            } else {
                harden.sum = 0;
            }


            // 만약에 같은 배터리를 사용하고 둘다 배터리 위치에 접근 가능하다
            if(a_idx == b_idx && gitae.sum == harden.sum) {
                gitae.sum /= 2;
                harden.sum /= 2;
            }

            int suum = gitae.sum + harden.sum;

            if(sum_max[time] < suum){
                sum_max[time] = suum;
            }

//            System.out.println("list " + list.get(0) + " " + list.get(1) + " " + suum);


            return;
        }

        for(int i=0; i<bc; i++){
            list.add(i);
            dfs(depth+1, list, gitae, harden, time);
            list.remove(list.size()-1);
        }


    }

    private static boolean isPossible(battery battery, person p) {

        int d = Math.abs(battery.r - p.r) + Math.abs(battery.c - p.c);

        if(d <= battery.range){
//            System.out.println(battery.r + "," + battery.c + "  " + p.r + "," + p.c);
            return true;
        } else {
            return false;
        }


    }

    private static void move_person(int dir, person p) {

        p.r += dy[dir];
        p.c += dx[dir];

    }

    static class person {
        int r;
        int c;
        int sum;

        person(int r, int c, int sum){
            this.r = r;
            this.c = c;
            this.sum = sum;
        }

    }

    static class battery {

        int r;
        int c;
        int range;
        int power;

        battery(int r, int c, int range, int power){
            this.r = r;
            this.c = c;
            this.range = range;
            this.power = power;
        }

    }
}