import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj20055 {
    static int n, k;
    static boolean[] robot;
    static int[] belt;
    static int s_rank = 1;
    static int res = 0;
    static PriorityQueue<robot> pq = new PriorityQueue();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());

        robot = new boolean[2*n+1];
        belt = new int[2*n+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=2*n; i++){
            int durability = Integer.parseInt(st.nextToken());
            belt[i] = durability;
        }

        while(true){
            res++;
            rotationBelt();
            moveRobot();
            firstRobotCheck();
            if(check() >= k){
                System.out.println(res);
                return;
            }
        }


    }

    private static int check() {

        int cnt = 0;
        for(int i=1; i<=2*n; i++){
            if(belt[i] <= 0)
                cnt++;
        }

        return cnt;
    }

    private static void firstRobotCheck() {
        if(!robot[1] && belt[1] > 0){
            pq.add(new robot(1, s_rank++));
            belt[1] -= 1;
            robot[1] = true;
        }
    }

    private static void moveRobot() {
        List<robot> list = new ArrayList<>();

        while(!pq.isEmpty()){
            robot cur_robot = pq.poll();
            if(cur_robot.idx == n-1 && !robot[n] && belt[n] > 0){
                robot[cur_robot.idx] = false;
                belt[n] -= 1;
            } else if(cur_robot.idx == 2*n && !robot[1] && belt[1] > 0) {
                robot[cur_robot.idx] = false;
                robot[1] = true;
                belt[1] -= 1;
                list.add(new robot(1, cur_robot.rank));
            } else if(cur_robot.idx != 2*n && !robot[cur_robot.idx + 1] && belt[cur_robot.idx+1] > 0){
                robot[cur_robot.idx] = false;
                robot[cur_robot.idx+1] = true;
                belt[cur_robot.idx+1] -= 1;
                list.add(new robot(cur_robot.idx+1, cur_robot.rank));
            } else {
                list.add(new robot(cur_robot.idx, cur_robot.rank));
            }
        }

        for(int i=0; i<list.size(); i++){
            pq.add(new robot(list.get(i).idx, list.get(i).rank));
        }

    }

    private static void rotationBelt() {


        // belt 이동
        int first = belt[2*n];
        int[] temp = new int[2*n+1];
        for(int i=1; i<=2*n; i++){
            temp[i] = belt[i];
        }

        for(int i=2; i<=2*n; i++){
            belt[i] = temp[i-1];
        }

        belt[1] = first;


        List<Integer> temp_list = new ArrayList<>();
        // 로봇 이동
        int cur = 0;
        while(!pq.isEmpty()){
            robot cur_robot = pq.poll();

            if(cur_robot.idx == n-1){
                robot[cur_robot.idx] = false;
            } else if(cur_robot.idx == 2*n){
                robot[2*n] = false;
                robot[1] = true;
                temp_list.add(1);
                temp_list.add(cur_robot.rank);
            } else {
                robot[cur_robot.idx] = false;
                robot[cur_robot.idx+1] = true;
                temp_list.add(cur_robot.idx+1);
                temp_list.add(cur_robot.rank);
            }
        }

        for(int i=0; i<temp_list.size(); i+=2){
            pq.add(new robot(temp_list.get(i), temp_list.get(i+1)));
        }

    }

    static class robot implements Comparable<robot>{
        int idx;
        int rank;

        robot(int idx, int rank){
            this.idx = idx;
            this.rank = rank;
        }

        @Override
        public int compareTo(boj20055.robot o) {
            if(this.rank - o.rank > 0){
                return 1;
            } else if(this.rank == o.rank){
                return 0;
            } else {
                return -1;
            }
        }
    }
}
