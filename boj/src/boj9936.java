import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj9936 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String explosion = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            stack.add(str.charAt(i));

            if(stack.size() >= explosion.length()){
                boolean flag = true;

                for(int k=0; k<explosion.length(); k++){
                    if(explosion.charAt(k) != stack.get(stack.size() - explosion.length() + k)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    int size = explosion.length();
                    while(size-->0){
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        str = sb.reverse().toString();


        if(str.equals("") || str == null){
            System.out.println("FRULA");
        } else {
            System.out.println(str);
        }

    }

    private static boolean check(String str, String explosion) {
        return str.contains(explosion);
    }

}
