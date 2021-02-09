import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj10814 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<pair> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new pair(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }

        Collections.sort(list, new Comparator<pair>(){

            @Override
            public int compare(pair p1, pair p2){
                if(p1.age > p2.age){
                    return 1;
                } else if(p1.age == p2.age){
                    if(p1.rank > p2.rank){
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });

        for(pair p : list){
            System.out.println(p.age + " " + p.name);
        }


    }

    private static class pair {

        int age;
        String name;
        int rank;

        pair(int age, String name, int rank){
            this.age = age;
            this.name = name;
            this.rank = rank;
        }

    }

}
