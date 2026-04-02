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
        ListNode pok1 = head, pok2 = head.next, prethodni = null;

        while (pok2!=null && pok2.next!=null) {
            pok1 = pok1.next;
            pok2 = pok2.next.next;
        }

        ListNode dPolovina = pok1.next;
        pok1.next = null;
        while (dPolovina!=null) {
            ListNode priv = dPolovina.next;
            dPolovina.next = prethodni;
            prethodni = dPolovina;
            dPolovina = priv;
        }

        pok1 = head; dPolovina = prethodni;
        while (dPolovina!=null) {
            ListNode priv1 = pok1.next, priv2 = dPolovina.next;
            pok1.next = dPolovina;
            dPolovina.next = priv1;
            pok1 = priv1;
            dPolovina = priv2;
        }
    }
}
