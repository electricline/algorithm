package programmers;

import java.util.HashSet;
import java.util.Set;

public class 스킬트리 {

    public static void main(String[] args) {

       Solution solution = new Solution();
       solution.solution("CBD", new String[] {"BACDE"});
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for(int i=0; i<skill_trees.length; i++){

                String cur = skill_trees[i];

                if(checkSkill(cur, skill))
                    answer++;

            }

            System.out.println(answer);

            return answer;
        }

        private boolean checkSkill(String skill, String order) {

            Set<Character> skillSet = new HashSet<>();

            for(int i=0; i<order.length(); i++){
                skillSet.add(order.charAt(i));
            }

            for(int i=0; i<skill.length(); i++){

                char temp = skill.charAt(i);

                // 스킬 선수관계 없음
                if(!skillSet.contains(temp) || temp == order.charAt(0)){
                    continue;
                }

                Set<Character> preSkillSet = new HashSet<>();

                //스킬 선수관계 set에 저장
                for(int j=0; j<order.length(); j++){

                    if(order.charAt(j) == temp){
                        break;
                    }

                    preSkillSet.add(order.charAt(j));
                }

                int cnt = 0;
                int num = preSkillSet.size();

                for(int j=0; j<i; j++){
                    if(preSkillSet.contains(skill.charAt(j))){
                        cnt++;
                        preSkillSet.remove(skill.charAt(j));
                    }
                }

                if(num != cnt){
                    return false;
                }



            }




            return true;
        }
    }
}
