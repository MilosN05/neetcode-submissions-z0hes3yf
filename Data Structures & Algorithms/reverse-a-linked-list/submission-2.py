# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:


        prethodniPok = None
        trenutniPok = head

        while trenutniPok!= None:
            kopijaT = trenutniPok.next
            trenutniPok.next = prethodniPok
            prethodniPok = trenutniPok
            trenutniPok = kopijaT

        return prethodniPok