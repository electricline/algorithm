import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj1427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            list.add(Character.getNumericValue(str.charAt(i)));
        }

        Collections.sort(list, Collections.reverseOrder());

        for(int i : list){
            System.out.print(i);
        }
    }

}
