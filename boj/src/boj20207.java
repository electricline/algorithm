import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj20207 {

    static int n,res = 0;
    static int[][] map = new int[1001][366];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<pair> pq = new PriorityQueue();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new pair(r,c));
        }

        while(!pq.isEmpty()){
            pair cur = pq.poll();

            int r = cur.start;
            int c = cur.end;
//            System.out.println("r " + r + " c " + c);
            boolean outFlag = false;
            for(int i=1; i<1001; i++){
                if(outFlag)
                    break;
                boolean flag = true;
                for(int k=r; k<=c; k++){
                    if(map[i][k] != 0){
                        flag = false;
                        break;
                    }
                }
                if(!flag) continue;
                for(int k=r; k<=c; k++){
                    map[i][k] = 1;
                }
                outFlag = true;
            }

        }

//        for(int i=1; i<4; i++){
//            for(int j=1; j<=12; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        int colLength = 0;
        int rowLength = 0;
        boolean flag = false;
        for (int j=1; j<366; j++) {
            flag = false;
            for (int i=1; i<1001; i++) {
                if (map[i][j] == 1) {
                    flag = true;
                    rowLength = Math.max(rowLength, i);
                }
            }
            if (!flag) {
                res +=  rowLength * colLength;
                rowLength = 0;
                colLength = 0;
            } else
                colLength++;
        }
        if(flag) {
            res +=  rowLength * colLength;
        }

        System.out.println(res);
    }

    static class pair implements Comparable<pair>{
        int start;
        int end;

        pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(pair o) {
            if(this.start - o.start > 0){
                return 1;
            } else if(this.start == o.start) {
                if(this.end - o.end < 0){
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }

}
