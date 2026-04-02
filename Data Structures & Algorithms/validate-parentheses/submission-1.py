class Solution:
    def isValid(self, s: str) -> bool:
        stack = []


        zagrade = ["[","(","{","]",")","}"]
        for i in range(len(s)):
            karakter = s[i]
            indexKaraktera = zagrade.index(karakter)
            if indexKaraktera<=2:
                stack.append(karakter)
            else:
                duzinaS = len(stack)
                if duzinaS>0 and stack[duzinaS-1]==zagrade[indexKaraktera-3]:
                    stack.pop()
                else:
                    return False


        return True if len(stack)==0 else False
