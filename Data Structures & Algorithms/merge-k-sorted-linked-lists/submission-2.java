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
    public ListNode mergeKLists(ListNode[] lists) {
// TC = o(nlogn) SC = o(n)
        // List<Integer> nodes = new ArrayList<>();
        
        // for(ListNode list : lists){
        //     while(list!=null){
        //         nodes.add(list.val);
        //         list= list.next;
        //     }
        // }
        // Collections.sort(nodes);

        // ListNode res = new ListNode(0);
        // ListNode curr = res;

        // for(int node : nodes){
        //     curr.next = new ListNode(node);
        //     curr = curr.next;
        // }

        // return dummy.next;
// tc =o(n*k) sc =o(1) -> inefficient tc for edge cases

        // //dummy assigning
        // ListNode dummy = new ListNode(0);
        // ListNode cur = dummy;
        // //traversing the whole list of linked lists
        // while(true){
        //     //assigning a minimum value for start
        //     int minNode = -1;

        //     //iterating the whole list of nodes
        //     for(int i=0;i<lists.length;i++){
        //         //skip null or fully traversed lists
        //         if(lists[i]==null){
        //             continue;
        //         }
        //         //minNode = -1 for i = 0 turns to minNode = 0, after that the comparision between values of nodes of different lists starts
        //         if(minNode == -1 || lists[minNode].val > lists[i].val){
        //             minNode = i;
        //         }
        //     }

        //     //if minNode = -1 outside of for loop then that means all lists have been completely traversed result is ready
        //     if(minNode == -1){
        //         break;
        //     }
        //     //otherwise update result list and update the node pointer of the list with current pointer as minimum in all the lists
        //     cur.next = lists[minNode];
        //     lists[minNode] = lists[minNode].next;
        //     cur = cur.next;
        // }
        // return dummy.next; 



        // now my primary intuition for this question, pick two lists and merge them and merge the result with the next one
        //tc =  o(n*k) sc = o(1)
        if (lists.length == 0) return null;

        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoLists(lists[i], lists[i - 1]);
        }
        return lists[lists.length - 1];
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while(list1 != null && list2 != null){
            if(list1.val<=list2.val){
                node.next = list1;
                list1 = list1.next;
            }else
            if(list2.val<list1.val){
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }
        return dummy.next;
    }
}
