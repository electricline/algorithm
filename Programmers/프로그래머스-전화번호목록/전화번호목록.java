class Solution {
        public boolean solution(String[] phone_book) {

            String prefix;
            for(int i=0; i<phone_book.length; i++){
                prefix = phone_book[i];
                for(int j=0; j<phone_book.length; j++){
                    if(i!=j)
                        continue;
                    if(phone_book[j].startsWith(prefix)){
                        return false;
                    }
                }

            }

            return true;
        }
    }