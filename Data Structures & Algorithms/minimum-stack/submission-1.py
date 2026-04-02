class MinStack:
    elementi = None
    brojac = 0

    def __init__(self):
        self.elementi = []

    def push(self, val: int) -> None:
        self.elementi.append(val)
        self.brojac+=1

    def pop(self) -> None:
        self.brojac-=1
        self.elementi.pop()

    def top(self) -> int:

        return self.elementi[self.brojac-1]

    def getMin(self) -> int:
        min1= None
        for i in range(len(self.elementi)):
            if min1==None or min1>self.elementi[i]:
                min1 = self.elementi[i]

        return min1