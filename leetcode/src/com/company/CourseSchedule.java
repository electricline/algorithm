package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CourseSchedule {

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.canFinish(3, new int[][] {{0,1},{0,2},{1,2}});

    }

    static class Solution {
        boolean[] visitied;
        List<List<Integer>> graph = new LinkedList();
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            visitied = new boolean[numCourses];
            getGraph(numCourses, prerequisites);

            for(int i=0; i<numCourses; i++){
                if(!findCycle(i))
                    return false;
            }

            return true;
        }

        private boolean findCycle(int cur) {
            if(!visitied[cur])
                return false;
            visitied[cur] = true;

            for(int i=0; i<graph.get(cur).size(); i++){
                if(!findCycle(graph.get(cur).get(i))){
                    return false;
                }
            }
            visitied[cur] = false;
            return true;
        }


        private void getGraph(int numCourses, int[][] prerequisites) {

            for(int i=0; i<numCourses; i++){
                graph.add(new LinkedList<>());
            }

            for(int i=0; i<prerequisites.length; i++){
                // [0,1] 1 -> 0, 현재 코스를 듣기 위한 선수 과목 리스트를 만듬.
                int preCourse = prerequisites[i][1];
                int course = prerequisites[i][0];
                List<Integer> list = graph.get(course);
                list.add(preCourse);
            }

        }
    }

}
