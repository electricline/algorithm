import java.util.*;

public class boj2108 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        long sum = 0;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        // 1. 산술평균
        System.out.println((int)Math.round((double)sum/n)); //산술평균

        출처: https://blue-boy.tistory.com/167 [코딩배우는 학생]
        // 2. 중앙값
        Arrays.sort(arr);
        System.out.println(arr[arr.length/2]);


        // 3. 최빈값
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0) +1);
        }

        int max = 0;
        int cnt = 0;
        int res = 0;
        Map<Integer, Integer> maxList = new TreeMap<>();
        for(int key : map.keySet()){
            if(map.get(key) > max){
                cnt = 0;
                maxList.clear();
                max = map.get(key);
                res = key;
                maxList.put(key, 0);
                cnt++;
            }
            if(map.get(key) == max){
                cnt++;
                maxList.put(key, 0);
            }
        }


        if(maxList.size() == 1){
            System.out.println(res);
        } else {
            int cnt2 = 0;
            for (int key : maxList.keySet()) {
                if (cnt2 != 0){
                    System.out.println(key);
                    break;
                }
                cnt2++;
            }
        }

        System.out.println(arr[arr.length-1]-arr[0]);


    }

}
