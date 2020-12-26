package com.company;

public class IntersectionofTwoLinkedLists {

    //  Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode curA = headA, curB = headB;

            while(curA != curB){
                curA = curA == null ? headB : headA.next;
                curB = curB == null ? headA : headB.next;
            }

            return curA;
        }
    }
}
