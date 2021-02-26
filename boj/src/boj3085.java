import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3085 {

    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];

        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        // 인접 가로
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                    char temp = map[i][j];
                    map[i][j] = map[i][j+1];
                    map[i][j+1] = temp;

                    check(map, n);

                    temp = map[i][j];
                    map[i][j] = map[i][j+1];
                    map[i][j+1] = temp;
            }
        }

        // 인접 세로

        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){

                char temp = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = temp;

                check(map, n);

                temp = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = temp;
            }
        }


        System.out.println(max);

    }

    private static void check(char[][] map, int n) {

        for(int i=0; i<n; i++){
            int cnt = 1;
            for(int j=0; j<n-1; j++){
                if(map[i][j] == map[i][j+1])
                    cnt++;
                else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        for(int i=0; i<n; i++){
            int cnt = 1;
            for(int j=0; j<n-1; j++){
                if(map[j][i] == map[j+1][i])
                    cnt++;
                else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }


    }
}
