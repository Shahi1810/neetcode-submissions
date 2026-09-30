/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //O(N) space:
        // ArrayList<ListNode> list = new ArrayList<>();
        // ListNode current = head;

        // while(current!=null){
        //     list.add(current);
        //     current=current.next;
        // }
        
        // int remId = list.size()-n;
        // if(remId == 0){
        //     return head.next;
        // }
        // list.get(remId-1).next = list.get(remId).next;
        // return head;


        //two pointer:
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy, right = head;

        while(n>0){
            right=right.next;
            n--;
        }

        while(right!=null){
            left=left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
