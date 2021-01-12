package com.company;

import java.util.LinkedList;

public class FindtheTownJudge {

    class Solution {
        LinkedList<LinkedList> res = new LinkedList();
        int sizeFlag = 0;
        public int findJudge(int N, int[][] trust) {
            if(N == 1) return 1;
            makeGraph(N, trust);
            LinkedList judgeList = findByJundgeList();
            if(sizeFlag > 1) return -1;
            return findByJudge(judgeList);
        }

        public int findByJudge(LinkedList<Integer> judgeList){

            for(int i=0; i<judgeList.size(); i++){
                int judgeNum = judgeList.get(i);
                int flag = 0;
                for(int j=0; j<res.size(); j++){
                    if(res.get(j).size() == 0) continue;
                    LinkedList list = res.get(j);
                    for(int k=0; k<list.size(); k++){
                        // System.out.println("judgeNum " + judgeNum + " listNum " + list.get(k));
                        if((int)list.get(k) == judgeNum){
                            flag = 1;
                        }
                    }
                    if(flag == 1){
                        continue;
                    } else {
                        break;
                    }
                }
                if(flag == 1){
                    return judgeNum;
                }
            }

            return -1;

        }

        public LinkedList<Integer> findByJundgeList(){

            LinkedList judgeList = new LinkedList();

            for(int i=0; i<res.size(); i++){
                if(res.get(i).size() == 0){
                    judgeList.add(i+1);
                    sizeFlag++;
                }
            }
            return judgeList;
        }

        public LinkedList<LinkedList> makeGraph(int N, int[][] trust){

            for(int i=0; i<N; i++){
                res.add(new LinkedList());
            }

            for(int i=0; i<trust.length; i++){
                LinkedList list = res.get(trust[i][0]-1);
                list.add(trust[i][1]);
            }

            return res;
        }
    }
    
}
