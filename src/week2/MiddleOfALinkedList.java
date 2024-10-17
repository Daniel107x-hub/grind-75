package week2;

import utils.ListNode;

public class MiddleOfALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(middleNode(head).val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        while(right != null && right.next != null){
            left = left.next;
            right = right.next.next;
        }
        return left;
    }
}
