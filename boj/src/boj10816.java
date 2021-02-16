import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10816 {

    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            int cnt = upperBound(num)-lowerBound(num);
            sb.append(cnt).append(" ");
        }

        System.out.println(sb);

    }

    private static int lowerBound(int num){
        int l = 0;
        int r = arr.length;

        while(l<r){

            int mid =(l+r)/2;

            if(arr[mid] >= num){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static int upperBound(int num){
        int l = 0;
        int r = arr.length;

        while(l<r){

            int mid = (l+r)/2;

            if(arr[mid] <= num){
                l = mid + 1;
            } else {
                r = mid;
            }

        }

        return l;

    }

    private static void binarySearch(int num) {
        int cnt = 0;
        int l = 0;
        int r = arr.length-1;

        while(l<=r){
            int mid = (l+r) / 2;
            if(arr[mid] == num){
                int temp = mid-1;
                while(mid < arr.length && arr[mid] == num){
                    cnt++;
                    mid++;
                }
                while(temp >= 0 && arr[temp] == num){
                    cnt++;
                    temp--;
                }
                break;
            } else if(arr[mid] > num){
                r = mid -1;
            } else {
                l = mid + 1;
            }

        }
        sb.append(cnt).append(" ");
    }

}
