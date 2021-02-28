public class targetNumber {
    static class Solution {
        static int answer = 0;
        public int solution(int[] numbers, int target) {
            dfs(numbers,target,0);

            return answer;
        }


         void dfs(int[] numbers, int target, int depth){
            if(depth == numbers.length){
                int sum=0;
                for(int num: numbers){
                    sum += num;
                }
                if(sum == target){
                    answer++;
                }
            } else {
                numbers[depth] *= 1;
                dfs(numbers,target, depth+1);
                System.out.println("Zz");
                numbers[depth]*=-1;
                dfs(numbers,target,depth+1);
            }
        }
    }


}
