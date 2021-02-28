import java.util.*; 
class Solution {
        public String[] solution(String[] record) {
            HashMap<String, String> map = new HashMap<>();
            int count=0; int idx=0;

            for(int i=0; i<record.length; i++){  // key, value �� �����
                String[] recordSplit = record[i].split(" ");
                if(!recordSplit[0].equals("Leave")){
                    map.put(recordSplit[1], recordSplit[2]);
                }
                
                if(!recordSplit[0].equals("Change")){
                    count++;
                }
            }

            String[] answer = new String[count]; // answer ����

            for(int j=0; j<record.length; j++){
                String[] recordSplit = record[j].split(" ");
                if(recordSplit[0].equals("Enter")){
                    answer[idx] = map.get(recordSplit[1])+"���� ���Խ��ϴ�.";
                    idx++;
                } else if(recordSplit[0].equals("Leave")){
                    answer[idx] = map.get(recordSplit[1])+"���� �������ϴ�.";
                    idx++;
                }
            }

            return answer;
        }
    }