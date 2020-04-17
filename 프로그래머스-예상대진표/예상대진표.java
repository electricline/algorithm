class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        if( (a+b+1)%4 == 0 && Math.abs(a-b) == 1){
            return 1;
        }
        
        while(n!=1){
            
            System.out.println(a);
            
            if(a != 1 && a%2 == 0){
                a = a/2;
            } else {
                a = (a+1)/2;
            }
            
            if(b%2 ==0){
                b = b/2;
            } else {
                b = (b+1)/2;
            }
            
            answer++;
            
            
            if( (a+b+1) % 4 == 0 && Math.abs(a-b) == 1)
                break;
            
            n = n/2;
            
        }
        
        

        return answer;
    }
}