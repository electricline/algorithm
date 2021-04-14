import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16935 {

    static int n,m,k;
    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num == 1){
                one();
            } else if(num == 2){
                two();
            } else if(num == 3){
                three();
            } else if(num == 4){
                four();
            } else if(num == 5){
                five();
            } else {
                six();
            }

        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }




    }

    private static void six() {

        int[][] temp = new int[map.length][map[0].length];

        int n = map.length;
        int m = map[0].length;
        int n2 = map.length/2;
        int m2 = map[0].length/2;


        for(int i=0; i<n2; i++){
            for(int j=0; j<m2; j++){
                temp[i][j] = map[i][m2+j];
            }
        }

        for(int i=0; i<n2; i++){
            for(int j=m2; j<m; j++){
                temp[i][j] = map[n2+i][j];
            }
        }

        for(int i=n2; i<n; i++){
            for(int j=0; j<m2; j++){
                temp[i][j] = map[i-n2][j];
            }
        }

        for(int i=n2; i<n; i++){
            for(int j=m2; j<m; j++){
                temp[i][j] = map[i][j-m2];
            }
        }

        map = temp;


    }

    private static void five() {

        int[][] temp = new int[map.length][map[0].length];

        int n = map.length;
        int m = map[0].length;
        int n2 = map.length/2;
        int m2 = map[0].length/2;

        for(int i=0; i<n2; i++){
            for(int j=0; j<m2; j++){
                temp[i][j] = map[n2+i][j];
            }
        }

        for(int i=0; i<n2; i++){
            for(int j=m2; j<m; j++){
                temp[i][j] = map[i][j-m2];
            }
        }

        for(int i=n2; i<n; i++){
            for(int j=0; j<m2; j++){
                temp[i][j] = map[i][j+m2];
            }
        }

        for(int i=n2; i<n; i++){
            for(int j=m2; j<m; j++){
                temp[i][j] = map[i-n2][j];
            }
        }

        map = temp;

    }

    private static void four() {

        // 왼쪽으로 90

        int[][] temp = new int[map[0].length][map.length];
        int n = map.length;
        int m = map[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = map[j][m-1-i];
            }
        }

        map = new int[map[0].length][map.length];
        map = temp;

    }

    private static void three() {

        // 오른쪽으로 90

        int[][] temp = new int[map[0].length][map.length];
        int n = map.length;; // 8
        int m = map[0].length; // 6


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = map[n-1-j][i];
            }
        }

        map = new int[map[0].length][map.length];

        map = temp;

    }

    private static void two() {

        // row는 그대로 col만 변경

        int[][] temp = new int[map.length][map[0].length];
        int n = map.length;
        int m = map[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                temp[i][j] = map[i][m-j-1];
            }
        }

        map = temp;


    }

    private static void one() {

        // col은 그대로 row만 변경

        int[][] temp = new int[map.length][map[0].length];
        int n = map.length;
        int m = map[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                temp[j][i] = map[n-j-1][i];
            }
        }

        map = temp;

    }


}
