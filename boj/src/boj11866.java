import java.util.*;

public class boj11866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList();

        for(int i=1; i<=n; i++){
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()){
            for(int i=0; i<k; i++){
                int temp = q.poll();
                if(i == k-1){
                    sb.append(temp).append(", ");
                } else {
                    q.add(temp);
                }
            }
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);

    }

}
