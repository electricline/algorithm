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
    static int time = 0;
    static int flag = -1;
    static boolean[][] visitied;
    static Queue<Integer> q = new LinkedList<>();
    static Queue<Integer> fq = new LinkedList<>();

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {

        input();
        BFS();

    }

    private static void BFS() {

        loop : while(!q.isEmpty()){

            spreadFire();
            int size = q.size();

            for (int i = 0; i < size/2; i++) {
                int cur_r = q.poll();
                int cur_c = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nr = cur_r + dr[dir];
                    int nc = cur_c + dc[dir];

                    if( nr < 0 || nr >= R || nc <  0 || nc >= C){
                        flag = ++time;
                        break loop;
                    }

                    if(visitied[nr][nc] || map[nr][nc] != 0)
                        continue;
                    visitied[nr][nc] = true;
                    q.add(nr); q.add(nc);
                }
            }
            time++;
        }

        System.out.println(flag == -1 ? "IMPOSSIBLE" : flag);
    }


    private static void spreadFire(){

        int fireSize = fq.size();

        for(int i=0; i<fireSize/2; i++){
            int fr = fq.poll(); int fc = fq.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = fr + dr[dir];
                int nc = fc + dc[dir];

                if( nr < 0 || nr >= R || nc <  0 || nc >= C) continue;
                if(map[nr][nc] != 0) continue;

                map[nr][nc] = 2;
                fq.add(nr); fq.add(nc);
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
                    q.add(i); q.add(j);
                    visitied[i][j] = true;
                }
                if(str.charAt(j) == 'F'){
                    map[i][j] = 2;
                    fq.add(i); fq.add(j);
                    visitied[i][j] = true;
                }
            }
        }
    }
}
