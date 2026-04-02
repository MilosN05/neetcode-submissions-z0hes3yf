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
    if (head==null || head.next ==null)
            return;
        ListNode[] niz = new ListNode[1000];
        int brojac =0;
        ListNode kopija = head;
        while (kopija!=null) {
            niz[brojac++] = kopija;
            kopija = kopija.next;

        }

        ListNode poslednji = null;
        for (int i=0, k=brojac-1;i<k;i++,k--) {
            ListNode kop = niz[i].next;
            poslednji = kop;

            niz[i].next = niz[k];

            if (kop!=niz[k])
                niz[k].next = kop;
            else
                niz[k].next=null;
        }
        if (brojac%2!=0) {
            poslednji.next = null;
        }
    }
}
