import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj14226 {

    static int n;
    static int res = Integer.MAX_VALUE;
    static boolean[][] visitied = new boolean[1001][1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        bfs();

        System.out.println(res);

    }

    private static void bfs() {

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(1,0,0));
        visitied[1][0] = true;

        while(!q.isEmpty()){

            pair cur = q.poll();


            if(cur.screen == n){
                res = Math.min(res, cur.cnt);
            }

            if(cur.cnt > n){
                continue;
            }

            int nextScreen;
            int nextClipboard;


            if(cur.screen < 1001){
                if(!visitied[cur.screen][cur.screen]){
                    visitied[cur.screen][cur.screen] = true;
                    q.add(new pair(cur.screen, cur.screen, cur.cnt+1));
                }
            }


            if(cur.clipboard > 0){
                nextScreen = cur.screen + cur.clipboard;
                if(nextScreen < 1001 && !visitied[nextScreen][cur.clipboard]) {
                    visitied[nextScreen][cur.clipboard] = true;
                    q.add(new pair(nextScreen, cur.clipboard, cur.cnt+1));
                }
            }

            if(cur.screen > 0){
                nextScreen = cur.screen - 1;
                if(nextScreen < 1001 && !visitied[nextScreen][cur.clipboard]) {
                    visitied[nextScreen][cur.clipboard] = true;
                    q.add(new pair(nextScreen, cur.clipboard, cur.cnt+1));
                }
            }


        }



    }


    static class pair {
        int screen;
        int clipboard;
        int cnt;

        pair(int screen, int clipboard, int cnt){
            this.screen = screen;
            this.clipboard = clipboard;
            this.cnt = cnt;
        }
    }

}
