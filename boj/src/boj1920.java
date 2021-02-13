    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.HashSet;
    import java.util.Set;
    import java.util.StringTokenizer;

    public class boj1920 {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());

            Arrays.sort(arr);

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++){
                int temp = Integer.parseInt(st.nextToken());
                if(find(temp,arr)){
                    System.out.println("1");
                } else
                    System.out.println("0");
            }
        }

        private static boolean find(int num, int[] arr) {

            int l = 0;
            int r = arr.length-1;

            while(l <= r){
                int mid = (l+r) / 2;

                if(arr[mid] == num){
                    return true;
                } else if(arr[mid] > num){
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }

            return false;

        }

    }
