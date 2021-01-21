package com.company;

public class PalindromicSubstrings {

    class Solution {
        int res;
        public int countSubstrings(String s) {

            for(int start=0; start<s.length(); start++){
                for(int end=start; end<s.length(); end++){
                    if(findPalindrom(s.substring(start,end+1))){
                        res++;
                    }
                }
            }
            return res;
        }

        private boolean findPalindrom(String str) {
            char[] chars = str.toCharArray();

            for(int i=0; i<chars.length/2; i++){
                if(chars[i] != chars[chars.length-1-i]){
                    return false;
                }
            }
            return true;
        }
    }
}
