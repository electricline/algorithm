package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleByBFS {


    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            int[] indegree = new int[numCourses];

            for(int i=0; i<prerequisites.length; i++){
                indegree[prerequisites[i][0]]++;
            }

            Queue<Integer> q = new LinkedList();

            for(int i=0; i<numCourses; i++){
                if(indegree[i] == 0)
                    q.add(i);
            }

            int cnt = 0;
            while(!q.isEmpty()){
                int preCourse = q.poll();
                cnt++;
                for(int i=0; i<prerequisites.length; i++){
                    if(prerequisites[i][1] == preCourse){
                        indegree[prerequisites[i][0]]--;
                        if(indegree[prerequisites[i][0]] == 0){
                            q.add(prerequisites[i][0]);
                        }
                    }
                }
            }

            if( cnt == numCourses) return true;

            return false;
        }
    }
}
