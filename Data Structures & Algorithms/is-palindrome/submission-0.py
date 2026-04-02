class Solution:
    def isPalindrome(self, s: str) -> bool:
        String = s.lower()
        prviPok = 0
        drugiPok = len(String) - 1


        String1 = ""
        String2=""

        while prviPok<len(String):
            prviChar  =String[prviPok]
            drugiChar = String[drugiPok]
            if (ord(prviChar)>=97 and ord(prviChar)<=122) or (ord(prviChar)>=48 and ord(prviChar)<=57):
                String1+=prviChar
            if (ord(drugiChar) >= 97 and ord(drugiChar) <= 122) or (ord(drugiChar) >= 48 and ord(drugiChar) <= 57):
                String2+=drugiChar

            prviPok+=1
            drugiPok-=1



        
        return String1==String2