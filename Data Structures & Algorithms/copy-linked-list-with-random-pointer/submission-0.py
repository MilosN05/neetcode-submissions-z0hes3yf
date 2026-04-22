"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
        def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
            if head==None:
                return None
            novaGlava = Node(head.val)
            kopijaDP = novaGlava
            kopija = head.next

            listaH = []
            listaH.append(head)
            listaNH = []
            listaNH.append(novaGlava)
            vezaH = dict()
            vezaNH = dict()


            while kopija!=None:
                kopijaDP.next = Node(kopija.val); listaNH.append(kopijaDP.next)

                kopijaDP = kopijaDP.next; listaH.append(kopija)

                kopija = kopija.next




            for i,j in zip(listaH,listaNH):
                if i.random!=None:
                    vezaH[i] = listaH.index(i.random)

                else:
                    vezaH[i] = None


                vezaNH[j] = vezaH[i]
            
            for i in listaNH:
                if vezaNH[i]!=None:
                    i.random = listaNH[vezaNH[i]]
                else:
                    i.random = None


            return novaGlava
        