import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj18870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] res = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            res[i] = arr[i];
        }

        Arrays.sort(res);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for(int i=0; i<arr.length; i++){
            if(i != 0 && res[i-1] == res[i]) continue;
            map.put(res[i], rank++);
        }

        for(int i=0; i<arr.length; i++){
            res[i] = map.get(arr[i]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i : res)
            sb.append(i).append(' ');

        System.out.println(sb);

    }

}
