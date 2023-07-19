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
        
        ListNode temp = new ListNode(0);
        temp.next = head; 
        ListNode start = temp, end = temp;
        while(n > 0){
            end = end.next;
            n--;
        }
        while(end.next != null){
            start = start.next;
            end = end.next;
        }        

        start.next = start.next.next;
        return temp.next;
    }
}