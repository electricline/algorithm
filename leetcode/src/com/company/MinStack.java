package com.company;

import java.util.LinkedList;
import java.util.Stack;

public class MinStack {

    Node head = null;

    /** initialize your data structure here. */

    public void push(int x) {
        if(head == null)
            head = new Node(x,x);
        else {
            head = new Node(x, Math.min(x, head.min), head);
        }

    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min){
            this.val = val;
            this.min = min;
            this.next = null;
        }

        private Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
