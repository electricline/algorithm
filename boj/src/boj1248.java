import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj1248 {

    static int n;
    static char[] chars;
    static char[][] map;
    static boolean[] visitied = new boolean[21];
    static StringBuilder sb = new StringBuilder();
    static boolean sFlag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int size = n * (n + 1) / 2;
        chars = new char[size];
        map = new char[n][n];
        chars = br.readLine().toCharArray();
//
//        List<Integer> tempList = new ArrayList<>();
//        tempList.add(-2);
//        tempList.add(5);
//        tempList.add(-3);
//        tempList.add(1);
//
//        System.out.println(createSmap(tempList));


        dfs(0, new ArrayList<>(), 0);
        System.out.println(sb);
    }

    private static void dfs(int depth, List<Integer> list, int idx) {
        if(depth == n){
            if(!sFlag && createSmap(list)){
                sFlag = true;
                for(int num : list){
                    sb.append(num);
                }
            }
            return;
        }

        for(int i=-10; i<=10; i++){
            int tempIdx = i;
            if(i < 0){
                tempIdx = i * -2;
            }
            if(visitied[tempIdx]) continue;
            visitied[tempIdx] = true;
            list.add(i);
            dfs(depth+1, list, i);
            list.remove(list.size()-1);
            visitied[tempIdx] = false;
        }

    }

    private static boolean createSmap(List<Integer> list) {

        char[] temp = new char[chars.length];
        int idx = 0;
        for(int i=0; i<n; i++){ // 0 , 1, 2, 3
            for(int j=i; j<n; j++){ //
                int num = 0;
                for(int k=i; k<=j; k++){
                    num += list.get(k);
                }
                if(num > 0){
                    temp[idx++] = '+';
                } else if(num == 0){
                    temp[idx++] = '0';
                } else {
                    temp[idx++] = '-';
                }
            }
        }

        boolean flag = true;
        for(int i=0; i<temp.length; i++){
            if(temp[i] != chars[i]){
                flag = false;
                break;
            }
        }

        if(flag)
            return true;
        else
            return false;


    }

}
