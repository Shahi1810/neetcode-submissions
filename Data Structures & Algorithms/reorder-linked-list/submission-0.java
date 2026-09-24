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
    public void reorderList(ListNode head) {
        if(head.next == null) return;

        ArrayList<ListNode> list = new ArrayList<>();
        ListNode current = head;

        while(current != null){
            list.add(current);
            current = current.next;
        }

        int first=0, last=list.size()-1;
        while(first<last){
            list.get(first).next = list.get(last);
            first++;
            if(first>=last){
                break;
            }
            list.get(last).next=list.get(first);
            last--;
        }

        list.get(first).next = null;
    }
}
