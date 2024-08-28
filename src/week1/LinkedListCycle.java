package week1;

import utils.ListNode;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode tail = new ListNode(-4);
        ListNode entry = new ListNode(2, new ListNode(0, tail));
        tail.next = entry;
        ListNode head = new ListNode(3, entry);
        System.out.println(hasCycle(new ListNode(1)));
    }

    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow.next != null && fast != null && fast.next != null){
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
