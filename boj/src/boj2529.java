import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2529 {

    static int k;
    static char[] chars;
    static boolean[] visitied = new boolean[10];
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    static String minString;
    static String maxString;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        chars = new char[k];
        String[] str = br.readLine().split(" ");

        for(int i=0; i<str.length; i++){
            chars[i] = str[i].charAt(0);
        }

        recursion(0, new StringBuilder());

        System.out.println(maxString);
        System.out.println(minString);
    }

    private static void recursion(int depth, StringBuilder sb) {
        if(depth == k+1){
            int[] arr = new int[sb.length()];

            for(int i=0; i<sb.length(); i++){
                arr[i] = sb.charAt(i) - '0';
            }
            boolean flag = true;
            for(int i=0; i<k; i++){
                if(chars[i] == '<'){
                    if(arr[i] < arr[i+1]){
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    if(arr[i] > arr[i+1]){
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag){
                long num = Long.parseLong(sb.toString());
                if(num > max){
                    max = num;
                    maxString = sb.toString();
                }
                if(min > num){
                    min = num;
                    minString = sb.toString();
                }
            }
            return;
        }

        for(int i=0; i<=9; i++){
            if(visitied[i]) continue;
            visitied[i] = true;
            recursion(depth+1, sb.append(i));
            sb.setLength(sb.length()-1);
            visitied[i] = false;
        }

    }

}
