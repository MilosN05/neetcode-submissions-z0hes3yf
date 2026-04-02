# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        kopija = head

        if kopija==None:
            return head
        listDodatna = [None,head]
        while kopija.next !=None:

            kopija = kopija.next
            listDodatna.append(kopija)


        i = len(listDodatna)-2
        while kopija!=None:

            kopija.next = listDodatna[i]
            kopija = kopija.next


            i-=1

        head = listDodatna[len(listDodatna)-1]
        return head