package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj4179 {

    static int R, C, SR, SC;
    static int[][] map;
    static int[][] tempMap;
    static boolean[][] visitied;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {

        input();
        BFS();

    }

    private static void BFS() {

        Queue<Integer> q = new LinkedList<>();
        q.add(SR); q.add(SC); q.add(1);
        visitied[SR][SC] = true;
        int fireFlag = 0;
        while(!q.isEmpty()){

            int r = q.poll(); int c = q.poll(); int time = q.poll();

//            System.out.println("cur r " + r + " cur c " + c + " time " + time);

            if(fireFlag != time){
                spreadFire();
                fireFlag = time;
            }

            for(int dir=0; dir<4; dir++){
                int nr = r + dr[dir];
                int nc = c + dc[dir];
//                System.out.println(nr +" " + nc);

                if(nr<0 || nr >=R || nc < 0 || nc>=C) continue;
                if(visitied[nr][nc]) continue;
                if(map[nr][nc] == 9 || map[nr][nc] == 2) continue;

                if(nr == 0 || nr == R-1 || nc == 0 || nc == C-1){
                    System.out.println(time+1);
                    return;
                }

                q.add(nr); q.add(nc); q.add(time+1);
                map[nr][nc] = 1;
                visitied[nr][nc] = true;
            }

        }

        System.out.println("IMPOSSIBLE");
    }

    private static void spreadFire(){

        Queue<Integer> fireQ = new LinkedList<>();

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == 2){
                    fireQ.add(i);
                    fireQ.add(j);
                }
            }
        }

        while (!fireQ.isEmpty()){

            int r = fireQ.poll(); int c = fireQ.poll();

            for(int dir=0; dir<4; dir++){
                int nr = r+dr[dir];
                int nc = c+dc[dir];

                if(nr<0 || nr >=R || nc < 0 || nc>=C) continue;
                if(map[nr][nc] == 9 || map[nr][nc] == 2) continue;
                map[nr][nc] = 2;
                visitied[nr][nc] = true;
            }
        }


//        System.out.println("=======FIRE=============");
//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visitied = new boolean[R][C];
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                if(str.charAt(j) == '#'){
                    map[i][j] = 9;
                }
                if(str.charAt(j) == '.'){
                    map[i][j] = 0;
                }
                if(str.charAt(j) == 'J'){
                    map[i][j] = 1;
                    SR = i; SC = j;
                }
                if(str.charAt(j) == 'F'){
                    map[i][j] = 2;
                    visitied[i][j] = true;
                }
            }
        }
    }
}
