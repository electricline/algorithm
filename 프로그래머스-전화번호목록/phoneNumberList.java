class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        boolean result = false;
        int len = phone_book.length;
        String temp = "";
        for(int i=0; i<len; i++){
            temp = phone_book[i];
            for(int j=0; j<len; j++){
                if(i != j ){
                    result = phone_book[i].startsWith(phone_book[j]);
                        if(result == true)
                            return false;
                }
            }   
        }
        return answer;
    }
}