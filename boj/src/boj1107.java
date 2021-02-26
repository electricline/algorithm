import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1107 {
    static boolean[] nums = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());

        if(cnt != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<cnt; i++){
                nums[Integer.parseInt(st.nextToken())] = true;
            }
        }


        int ans = Math.abs(num - 100);

        for (int i = 0; i < 1000000; i++) {
            int len = check(i);

            if (len > 0) {
                int press = Math.abs(i - num);

                if(ans > len + press){
                    ans = len + press;
                }

            }
        }

        System.out.println(ans);

    }

    private static int check(int num) {
        if(num == 0 && nums[num]){
            return 0;
        }
        if(num ==0 && !nums[num]){
            return 1;
        }

        int len = 0;

        while(num > 0){
            if(nums[num%10]){
                len = 0;
                return len;
            }
            len++;
            num /= 10;
        }

        return len;
    }

}
