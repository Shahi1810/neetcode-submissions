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
    public ListNode reverseKGroup(ListNode head, int k) {
        int c=0;
        ListNode cur = head;
        while(cur!=null && c<k){
            cur = cur.next;
            c++;
        }

        if(c==k){
            cur = reverseKGroup(cur,k);
            
            while(c-- > 0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}
