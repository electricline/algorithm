package com.company;

public class AdditiveNumber {

    public static void main(String[] args) {
        System.out.println("a" + "c".substring(1));
    }


    class Solution {
        public boolean isAdditiveNumber(String num) {

            for (int i = 1; i < num.length() - 1; i++) {
                for (int j = i + 1; j < num.length(); j++) {
                    long first = check(num.substring(0, i));
                    long second = check(num.substring(i, j));
                    if (first == -1 || second == -1) continue;
                    if (DFS(first, second, num.substring(j)))
                        return true;
                }
            }
            return false;
        }

        private boolean DFS(long a, long b, String s) {

            if (s.length() == 0) return true;

            long c = a + b;
            String temp = String.valueOf(c);
            if (!s.startsWith(temp))
                return false;

            return DFS(b, c, s.substring(temp.length()));
        }

        private long check(String s) {
            if (!s.equals("0") && s.startsWith("0"))
                return -1;
            return Long.parseLong(s);
        }

    }
}
