package week2;

import utils.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root = reverseList(root);
        System.out.println("Hello");
    }

    public static ListNode reverseList(ListNode head){
        if(head == null) return head;
        ListNode prev = null;
        ListNode next = head.next;
        while(head.next != null){
            head.next = prev;
            prev = head;
            head = next;
            next = head.next;
        }
        head.next = prev;
        return head;
    }
}
