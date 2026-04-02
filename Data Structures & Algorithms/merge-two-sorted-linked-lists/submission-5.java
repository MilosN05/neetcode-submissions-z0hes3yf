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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode kopija1 = list1;
        ListNode kopija2 = list2;

        ListNode glava = new ListNode();
        ListNode trenutni = glava;

        while (kopija1!=null && kopija2!=null) {

            if (kopija1.val<=kopija2.val) {
                trenutni.next = kopija1;
                kopija1 = kopija1.next;
            }
            else {
                trenutni.next = kopija2;
                kopija2= kopija2.next;
            }
            trenutni = trenutni.next;
        }

        if (kopija1==null)
            trenutni.next =kopija2;
        else
            trenutni.next = kopija1;
        return glava.next;
    }
}