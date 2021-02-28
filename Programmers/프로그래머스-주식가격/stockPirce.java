class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int temp;
        int temp2=999;
        for(int i=0; i<prices.length; i++){
            temp = prices[i];
            for(int j=i+1; j<prices.length; j++){
                if(temp > prices[j] && i!=j){
                    answer[i] = j-i;
                    break;
                }
                answer[i] = prices.length - 1 - i;

            }
        }
        
        return answer;

    }
}