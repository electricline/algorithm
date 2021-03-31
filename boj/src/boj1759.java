import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj1759 {

    static int l, c;
    static char[] arr;
    static boolean[] visitied;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        visitied = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);


        recursion(0, new StringBuilder(), 0);

    }

    private static void recursion(int depth, StringBuilder sb, int idx) {
        if(depth == l){

            // check
            int moeum = 0;
            int jaeum = 0;
            for(int i=0; i<sb.length(); i++){
                if(sb.charAt(i) == 'a' || sb.charAt(i) == 'e' || sb.charAt(i) == 'i' || sb.charAt(i) == 'o' || sb.charAt(i) == 'u'){
                    moeum++;
                } else {
                    jaeum++;
                }
            }
            if(moeum >= 1 && jaeum >= 2){
                boolean flag = true;
                for(int i=0; i<sb.length()-1; i++){
                    if(sb.charAt(i) > sb.charAt(i+1)){
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    System.out.println(sb.toString());
            }

            return;
        }

        for(int i=idx; i<arr.length; i++){
            if(visitied[i]) continue;
            visitied[i] = true;
            recursion(depth+1, sb.append(arr[i]),i+1);
            sb.setLength(sb.length()-1);
            visitied[i] = false;
        }






    }

}
