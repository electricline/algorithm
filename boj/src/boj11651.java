import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj11651 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<pair2> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new pair2(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).r + " " +list.get(i).c);
        }

    }

    static class pair2 implements Comparable<pair2> {

        int r;
        int c;

        pair2(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(pair2 next){
            if(this.c - next.c > 0){
                return 1;
            } else if(this.c == next.c){

                if(this.r - next.r > 0){
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
