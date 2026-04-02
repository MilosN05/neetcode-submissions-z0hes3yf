# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if head==None:
            return False


        prviPok = head
        drugiPok = head

        while True:
            try:
                prviPok = prviPok.next
                drugiPok = drugiPok.next.next
                if prviPok==drugiPok:
                    return True
            except:
                return False