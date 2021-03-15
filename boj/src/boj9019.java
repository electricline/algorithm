import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj9019 {

    static int a, b;
    static String res;
    static boolean[] visitied = new boolean[10001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            solve();
            visitied = new boolean[10001];
            sb.append(res).append('\n');
            res = "";
        }
        System.out.println(sb);
    }

    private static void solve() {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(a,""));

        while(!q.isEmpty()){

            pair cur = q.poll();
//            System.out.println("cur num " + cur.num + " cur str" + cur.str);
            if(cur.num == b){
                res = cur.str;
                break;
            }


//            System.out.println(cur.num);

            if(visitied[cur.num])
                continue;

            visitied[cur.num] = true;


            int val;

            val = D(cur.num);
            q.add(new pair(val, cur.str + "D"));

            val = S(cur.num);
            q.add(new pair(val, cur.str + "S"));

            val = L(cur.num);
            q.add(new pair(val, cur.str + "L"));

            val = R(cur.num);
            q.add(new pair(val, cur.str + "R"));


        }


    }

    private static int R(int num) {

        int temp = (num%10)*1000;
        temp += (num/10);

        return temp;

    }

    private static int L(int num) {

        int temp = (num%1000)*10;
        temp += num/1000;

        return temp;

    }

    private static int S(int cur) {

        if(cur == 0)
            return 9999;

        return cur-1;

    }

    private static int D(int cur) {
        return (cur * 2) % 10000;

    }

    static class pair {
        int num;
        String str;
        pair(int num, String str){
            this.num = num;
            this.str = str;
        }

    }

}
