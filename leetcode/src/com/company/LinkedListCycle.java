package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListCycle {


     // Definition for singly-linked list.
     class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
     }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();

            while(head != null){
                if(set.contains(head.next)){
                    return true;
                }
                set.add(head);
                head = head.next;
            }

            return false;
        }

        public boolean hasCycl2(ListNode head) {
            if(head == null) return false;

            ListNode slow = head;
            ListNode fast = head.next;

            while(slow != fast){
                if(fast == null || fast.next == null) return false;

                slow = slow.next;
                fast = fast.next.next;

            }

            return true;
        }
    }

}
