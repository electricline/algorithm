

import java.util.*;

public class boj1181 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length())
                    return 1;
                else if(o1.length() < o2.length())
                    return -1;
                else
                    return o1.compareTo(o2);
            }
        });

        for(int i = 0; i < N ; i++)
            set.add(sc.nextLine());


        for(String s : set)
            System.out.println(s);
    }
}
