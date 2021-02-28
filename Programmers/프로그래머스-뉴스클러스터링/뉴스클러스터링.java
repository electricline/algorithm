import java.util.*;
class Solution {
  public int solution(String str1, String str2) {
      int answer = 0;
      
      str1 = str1.toUpperCase();
      str2 = str2.toUpperCase();
      
      ArrayList<String> setA = new ArrayList<>();
      ArrayList<String> setB = new ArrayList<>();
      ArrayList<String> setC = new ArrayList<>();
      ArrayList<String> setD = new ArrayList<>();
      
      String newStr1 = "";
      String newStr2 = "";
      
      for(int i=0; i<str1.length(); i++){
          char ch = str1.charAt(i); 
          newStr1 += String.valueOf(ch);
          
          if(newStr1.length() == 2){
              char ch2 = newStr1.charAt(0);
              char ch3 = newStr1.charAt(1);
              
              if( (ch2>= 'A' && ch2 <= 'Z') && (ch3 >= 'A' && ch3 <= 'Z')){
                  newStr2 += String.valueOf(ch2);
                  newStr2 += String.valueOf(ch3);
                  setA.add(newStr2);
                  setC.add(newStr2);
                  newStr1 = "";
                  newStr1 += String.valueOf(ch3);
                  newStr2 ="";
              } else {
                  newStr1 = "";
                  newStr1 += String.valueOf(ch3);
                  newStr2 = "";
              }
          }
      }
      newStr1 = "";
      newStr2 = "";
      
      for(int i=0; i<str2.length(); i++){
          char ch = str2.charAt(i); 
          newStr1 += String.valueOf(ch);
          
          if(newStr1.length() == 2){
              char ch2 = newStr1.charAt(0);
              char ch3 = newStr1.charAt(1);
              
              if( (ch2>= 'A' && ch2 <= 'Z') && (ch3 >= 'A' && ch3 <= 'Z')){
                  newStr2 += String.valueOf(ch2);
                  newStr2 += String.valueOf(ch3);
                  setB.add(newStr2);
                  setC.add(newStr2);
                  newStr1 = "";
                  newStr1 += String.valueOf(ch3);
                  newStr2 = "";
              } else {
                  newStr1 = "";
                  newStr1 += String.valueOf(ch3);
                  newStr2 = "";
              } 
          }
      }
      
      
      
//       for(int i=0; i<setA.size()+setB.size(); i++){
          
//       }
      
      
//       for(int i=0; i<str2.length(); i++){
//           char ch = str2.charAt(i); 
          
//           if( (ch >= 'A' && ch <= 'Z')){
//               newStr2 += String.valueOf(ch);
//               if(newStr2.length() == 2){
//                   setB.add(newStr2);
//                   setC.add(newStr2);
//                   newStr2= "";
//                   newStr2 += String.valueOf(ch);
//               }
//           }
//       }
      int total = setA.size() + setB.size();
      int intersection = 0;
      String tempA = "";
      String tempB = "";
      String tempC = "";
      for(int i=0; i<setC.size(); i++){
          tempC = setC.get(i);
          
          for(int j=i+1; j<setC.size(); j++){
              tempB = setC.get(j);
              if(tempC.equals(tempB) && !(setD.contains(tempC))){
                  setD.add(tempC);
              }
          }
      }
      
      int countA = 0;
      int countB = 0;
      int countC = 0;
      int count = 0;
      for(int i=0; i<setD.size(); i++){
          
          countA = 0;
          countB = 0;
          
          tempA = setD.get(i);
          
          for(int j=0; j<setA.size(); j++){
              tempB = setA.get(j);
              
              if(tempA.equals(tempB))
                  countA++;
          }
          
          for(int k=0; k<setB.size(); k++){
              tempB = setB.get(k);
              
              if(tempA.equals(tempB))
                  countB++;
          }
          
          if(countA > countB)
              countC = countB;
          else 
              countC = countA;
          
          count += countC;
          
      }

      double a = (double) count / (total-count);
      a *= 65536;
      answer = (int) a;
      
      if(setA.size()==0 && setB.size()==0)
          return 65536;
      
      
      return answer;
  }
}