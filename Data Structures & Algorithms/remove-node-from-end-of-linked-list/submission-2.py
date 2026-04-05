# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if head==None or head.next == None:
            return None

        duzina = 0

        kopija = head
        while kopija!=None:
            duzina+=1
            kopija = kopija.next

        prethodni = None
        kopija = head
        zOb = duzina-n


        if zOb==0:
            head = head.next
            return head
        i=0
        while kopija!=None:

            if i==zOb:
                prethodni.next = kopija.next
                break

            prethodni = kopija
            kopija =kopija.next
            i+=1
        return head