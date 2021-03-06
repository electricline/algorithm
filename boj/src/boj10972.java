import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10972 {

    static int[] arr;
    static int n;
    static boolean flag;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        next_permutation();
        if(!flag){
            for(int i=0; i<arr.length; i++){
                System.out.print(arr[i] + " ");
            }
        }

    }

    private static void next_permutation() {

        int idx = arr.length-2;

        while(idx >= 0 && arr[idx] >= arr[idx+1])
            idx--;


        if(idx != -1){
            int target = arr.length-1;
            while(arr[target] <= arr[idx]){
                target--;
            }

            swap(idx,target);
        } else {
            System.out.println(-1);
            flag = true;
            return;
        }

        int start = idx+1;
        int end = arr.length-1;
        while(start<end){
            swap(start,end);
            start++;
            end--;
        }


    }

    public static void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
