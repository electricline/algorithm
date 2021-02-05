import java.util.Arrays;
import java.util.Scanner;

public class boj11403 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N+1][N+1];
        int[] arr = new int[N+1];
        int[][] graph = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<=N; i++){
            dfs(map, arr, i);

            for(int j=1; j<=N; j++){
                graph[i][j] = arr[j];
            }
            Arrays.fill(arr, 0);
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++)
                System.out.print(graph[i][j]+" ");
            System.out.println();
        }

    }

    private static void dfs(int[][] map, int[] arr, int v) {
        int n = map.length-1;

        for(int i=1; i<=n ; i++){
            if(map[v][i] == 1 && arr[i] == 0){
                arr[i] = 1;
                dfs(map, arr, i);
            }
        }
    }
}
