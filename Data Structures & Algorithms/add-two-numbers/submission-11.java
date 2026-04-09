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
        ListNode kopijal1 =l1, kopijal2 = l2, zResenje =null, prethodni=null;

        int nL1 = 0, nL2 =0;
        while (kopijal1!=null) {
            kopijal1=kopijal1.next;
            nL1++;
        }
        while (kopijal2!=null) {
            kopijal2=kopijal2.next;
            nL2++;
        }
        kopijal1=l1;
        kopijal2=l2;

        if (nL1<=nL2)
            zResenje=l2;
        else zResenje=l1;


        int prenos =0, suma=0;
        while (kopijal1!=null || kopijal2!=null ) {

            if (kopijal1==null) {
                suma = kopijal2.val;
                kopijal2 = kopijal2.next;
            }
            else if (kopijal2==null) {
                suma = kopijal1.val;
                kopijal1=kopijal1.next;
            }
            else {
                suma = kopijal1.val + kopijal2.val;
                kopijal1=kopijal1.next;
                kopijal2 = kopijal2.next;

            }
            if (prenos==1) {suma+=1;prenos-=1;}

            if (suma>=10) {
                suma-=10;
                prenos+=1;
            }
            zResenje.val = suma;
            prethodni = zResenje;
            zResenje = zResenje.next;

        }
      
        if (prenos==1) prethodni.next=new ListNode(prenos);



        return nL1<=nL2 ? l2:l1;
    }
}
