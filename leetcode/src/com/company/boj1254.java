package com.company;

import java.util.Scanner;

public class boj1254 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        StringBuilder sb = new StringBuilder(str);

        int i = 0; int len = str.length();
        while(true){

            if(check(str.substring(i))) {
                System.out.println(sb.length());
                break;
            }

            sb.append(str.charAt(i));
            i++;
        }

    }

    private static boolean check(String str) {

        for(int i=0; i<=str.length()/2; i++){

            if(str.charAt(i) == str.charAt(str.length()-i-1)){
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
