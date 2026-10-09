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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        HashMap<ListNode, ListNode> nodes = new HashMap<>();
        ListNode i1=l1, i2=l2;
        ArrayList<Integer> sum = new ArrayList<>();
        int r=0, q=0;
        while(i1!=null && i2!=null){
            if((i1.val+i2.val+q) >= 10){
                r = (i1.val+i2.val+q)%10;
                q = (i1.val+i2.val+q)/10; 
                sum.add(r);
            }else{
                sum.add((i1.val+i2.val)+q);
                q=0;
            }
            i1=i1.next;
            i2=i2.next;
        }
        ListNode newList = new ListNode(0);
        ListNode run = newList; 
        
        for(int i =0;i<sum.size();i++){
            run.next = new ListNode(sum.get(i));
            run = run.next;
        }
        
        while(i1!=null){
            if((q+i1.val)>= 10){
                r = (i1.val+q)%10;
                q = (i1.val+q)/10;
                run.next=new ListNode(r);
            }else{
                run.next = new ListNode((q+i1.val));
                q=0;
            }
            run=run.next;
            i1=i1.next;
        }

        while(i2!=null){
            if((q+i2.val)>= 10){
                r = (i2.val+q)%10;
                q = (i2.val+q)/10;
                run.next=new ListNode(r);
            }else{
                run.next = new ListNode((q+i2.val));
                q=0;
            }
            run=run.next;
            i2=i2.next;
        }

        if(q!=0){
            run.next = new ListNode(q);
        }

        return newList.next;
        
    }
}
