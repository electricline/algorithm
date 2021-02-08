import java.util.*;

public class boj11650 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<pair> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new pair(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).r + " " +list.get(i).c);
        }

    }

    static class pair implements Comparable<pair> {

        int r;
        int c;

        pair(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(pair next){
            if(this.r - next.r > 0){
                return 1;
            } else if(this.r == next.r){

                if(this.c - next.c > 0){
                    return 1;
                } else {
                    return -1;
                }

            } else {
                return -1;
            }


        }

    }

}
