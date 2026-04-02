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
        List<Integer> sviCvorovi = new LinkedList<>();
        ListNode kopija1 = list1;
        if (list1==null)
            return list2;
        else if (list2==null) {
            return list1;
        }
        int ucitanaDruga = 0;
        while (true) {
            sviCvorovi.add(kopija1.val);

            
            if (kopija1.next==null && ucitanaDruga==0) {
                kopija1.next = list2;
                ucitanaDruga =1;
            }
            else if (kopija1.next==null && ucitanaDruga==1)
                break;

            kopija1 = kopija1.next;

        }
        Collections.sort(sviCvorovi);
        kopija1=list1;

        for (Integer element:sviCvorovi) {
            kopija1.val = element;
            kopija1 = kopija1.next;
        }
        return list1;
    }
}