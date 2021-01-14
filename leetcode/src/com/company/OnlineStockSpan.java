package com.company;

import java.util.*;

public class OnlineStockSpan {

    class StockSpanner {

        Deque<pair> dq;
        public StockSpanner() {
            dq = new LinkedList<>();
        }

        public int next(int price) {

            if(dq.size() == 0){
                dq.add(new pair(price, 1));
                return 1;
            }
            int cnt = 1;

            while(price >= dq.peekLast().price){
                pair prev = dq.pollLast();
                cnt += prev.cnt;
            }
            dq.push(new pair(price, cnt));

            return cnt;
        }
    }

    class pair {
        int price;
        int cnt;

        pair(int price, int cnt){
            this.price = cnt;
            this.cnt = cnt;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
