import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.*;

public class boj12100 {


    static int n;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int res = 0;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, new ArrayList<>());

        System.out.println(res);
    }

    private static void dfs(int depth, List<Integer> list) {

        if(depth == 5){
            calc(list, copyMap());
            return;
        }

        for(int i=1; i<=4; i++){
            list.add(i);
            dfs(depth+1, list);
            list.remove(list.size()-1);
        }


    }

    private static void calc(List<Integer> list, int[][] copyMap) {

        for(int i=0; i<list.size(); i++){
            move(list.get(i), copyMap);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                res = Math.max(res, copyMap[i][j]);
            }
        }

    }

    private static void move(int dir, int[][] tempMap) {
        Queue<Integer> q = new LinkedList<>();
        if(dir == 1){ // 왼쪽

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(tempMap[i][j] == 0) continue;
                    q.add(tempMap[i][j]);
                    tempMap[i][j] = 0;
                }
                Queue<Integer> q2 = new LinkedList<>();
                while(!q.isEmpty()){
                    int cur = q.poll();
                    if(!q.isEmpty() && cur == q.peek()){
                        cur *= 2;
                        q.poll();
                    }
                    q2.add(cur);
                }
                int idx = 0;
                while(!q2.isEmpty()){
                    tempMap[i][idx++] = q2.poll();
                }
            }

        } else if(dir == 2){ // 오른쪽

            for(int i=0; i<n; i++){
                for(int j=n-1; j>=0; j--){
                    if(tempMap[i][j] == 0) continue;
                    q.add(tempMap[i][j]);
                    tempMap[i][j] = 0;
                }
                Queue<Integer> q2 = new LinkedList<>();
                while(!q.isEmpty()){
                    int cur = q.poll();
                    if(!q.isEmpty() && cur == q.peek()){
                        cur *= 2;
                        q.poll();
                    }
                    q2.add(cur);
                }
                int idx = n-1;
                while(!q2.isEmpty()){
                    tempMap[i][idx--] = q2.poll();
                }
            }

        } else if(dir == 3){ // 위쪽

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(tempMap[j][i] == 0) continue;
                    q.add(tempMap[j][i]);
                    tempMap[j][i] = 0;
                }
                Queue<Integer> q2 = new LinkedList<>();
                while(!q.isEmpty()){
                    int cur = q.poll();
                    if(!q.isEmpty() && cur == q.peek()){
                        cur *= 2;
                        q.poll();
                    }
                    q2.add(cur);
                }
                int idx = 0;
                while(!q2.isEmpty()){
                    tempMap[idx++][i] = q2.poll();
                }
            }

        } else { // 아래쪽

            for(int i=0; i<n; i++){
                for(int j=n-1; j>=0; j--){
                    if(tempMap[j][i] == 0) continue;
                    q.add(tempMap[j][i]);
                    tempMap[j][i] = 0;
                }
                Queue<Integer> q2 = new LinkedList<>();
                while(!q.isEmpty()){
                    int cur = q.poll();
                    if(!q.isEmpty() && cur == q.peek()){
                        cur *= 2;
                        q.poll();
                    }
                    q2.add(cur);
                }
                int idx = n-1;
                while(!q2.isEmpty()){
                    tempMap[idx--][i] = q2.poll();
                }
            }

        }



    }

    private static int[][] copyMap() {

        int[][] temp = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = map[i][j];
            }
        }

        return temp;
    }

}
