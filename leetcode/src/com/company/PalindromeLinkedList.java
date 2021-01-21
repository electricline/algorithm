package com.company;

public class PalindromeLinkedList {


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        int length=1;
        public boolean isPalindrome(ListNode head) {

            if(head == null) return true;

            ListNode node = head;

            while(node.next != null){
                length++;
                node = node.next;
            }

            node = head;
            int[] arr = new int[length];
            for(int i=0; i<length; i++){
                arr[i] = node.val;
                node = node.next;
            }

            for(int i=0; i<length/2; i++){
                if(arr[i] != arr[length-1-i])
                    return false;
            }

            return true;
        }
    }


}
