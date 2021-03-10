package com.company;

public class ValidSudoku {

    public static void main(String[] args) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.println(" i " + (i/3*3 + j/3) + " j " + (i%3*3 + j%3));
            }
        }
    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {

            for(int i=0; i<3; i++){
                for(int j=0; j<9; j++){
                    boolean[] visitied = new boolean[9];
                    for(int k=0; k<9; k++){
                        if(i == 0){
                            //가로
                            if(board[j][k] == '.') continue;
                            int val = Character.getNumericValue(board[j][k])-1;
                            if(visitied[val])
                                return false;
                            else {
                                visitied[val] = true;
                            }

                        } else if(i == 1){
                            // 세로
                            if(board[k][j] == '.') continue;
                            int val = Character.getNumericValue(board[k][j])-1;
                            if(visitied[val])
                                return false;
                            else {
                                visitied[val] = true;
                            }
                        } else {
                            // 3 by 3
                            char c = board[j/3*3 + k/3][j%3*3 + k%3];
                            if(c == '.') continue;
                            if(visitied[Character.getNumericValue(c)-1]){
                                return false;
                            } else {
                                visitied[Character.getNumericValue(c)-1] = true;
                            }
                        }

                    }
                }
            }
            return true;
        }
    }
}
