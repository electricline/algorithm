package com.company;

import java.util.Scanner;

public class N과M1 {

    static int[] arr;
    static boolean[] visitied;
    static int N, M;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        arr = new int[N+1];
        visitied = new boolean[N+1];

        DFS(0);

    }

    private static void DFS(int depth) {

        if(depth == M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(visitied[i]) continue;
            visitied[i] = true;
            arr[depth] = i;
            DFS(depth+1);
            visitied[i] = false;
        }


    }
}
