import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16956 {

    static char[][] map;
    static int r,c;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for(int i=0; i<r; i++){
            String[] temp = br.readLine().split("");
            for(int j=0; j<c; j++){
                map[i][j] = temp[j].charAt(0);
            }
        }


        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == 'W'){
                    for(int dir=0; dir<4; dir++){
                        int nr = i + dy[dir];
                        int nc = j + dx[dir];

                        if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                        if(map[nr][nc] == '.')
                            map[nr][nc] = 'D';
                    }
                }
            }
        }


        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == 'S'){
                    for(int dir=0; dir<4; dir++){
                        int nr = i + dy[dir];
                        int nc = j + dx[dir];

                        if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                        if(map[nr][nc] == 'W'){
                            System.out.println(0);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(1);

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }



    }

}
