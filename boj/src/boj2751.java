import java.util.*;

public class boj2751 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();

        for(int val : arr){
            sb.append(val + "\n");
        }

        System.out.println(sb);

    }

}
