import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class boj1021 {

    static Deque<Integer> deque = new ArrayDeque<>();
    static int res = 0;
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();


        for(int i=1; i<=n; i++){
            deque.add(i);
        }

        for(int i=0; i<m; i++){
            int num = sc.nextInt();
//            System.out.println("num " + num);
            if(num == deque.peekFirst()){
                deque.pollFirst();
            } else {
                if(findDistance(num)){
                    while(true){
                        left();
                        res++;
//                        System.out.println(deque);
                        if(num == deque.peekFirst()){
                            deque.pollFirst();
                            break;
                        }
                    }
                } else {
                    while(true){
                        right();
                        res++;
//                        System.out.println(deque);
                        if(num == deque.peekFirst()){
                            deque.pollFirst();
                            break;
                        }
                    }
                }
            }

        }

        System.out.println(res);

    }

    public static boolean findDistance(int num){

        // 1. 왼쪽부터의 거리
        Iterator<Integer> it = deque.iterator();

        int leftDistance = 0;
        while(it.hasNext()){
            if(it.next() == num){
                break;
            } else {
                leftDistance++;
            }
        }
        // 2. 오른쪽부터의 거리
        int rightDistacne = deque.size() - leftDistance;

//        System.out.println("r" +  rightDistacne + " l " + leftDistance);

        if(rightDistacne > leftDistance){
            return true;
        } else {
            return false;
        }



    }

    public static void left() {
        int temp = deque.pollFirst();
        deque.addLast(temp);
    }

    public static void right() {
        int temp = deque.pollLast();
        deque.addFirst(temp);
    }

}
