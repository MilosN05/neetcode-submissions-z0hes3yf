class Solution {
    public String longestPalindrome(String s) {
        //pretraga samo neparnih palindroma
        String palindrome;
        int najvecaDuzina=0;
        int levo =0;
        int desno = 1;
        for (int i=0;i<s.length();i++) {
            int curMoveLeft =i-1;
            int curMoveRight = i+1;

            
           
          
            while (curMoveLeft>=0 && curMoveRight<s.length() &&  s.charAt(curMoveLeft)==s.charAt(curMoveRight)) {
                curMoveLeft-=1;
                curMoveRight+=1;
               


            }
            curMoveLeft+=1;
            curMoveRight-=1;

            if (curMoveRight+1-curMoveLeft > najvecaDuzina) {
                najvecaDuzina = curMoveRight+1-curMoveLeft;
                levo = curMoveLeft;
                desno = curMoveRight;
            }
        }

        if (s.length()>1)
            //pretraga parnih palindroma
            for (int i=0;i<s.length();i++) {
                int parOdI=i+1;
                int curMoveLeft =i-1;
                int curMoveRight = parOdI+1;
                
                if  (parOdI==s.length() || s.charAt(i)!=s.charAt(parOdI))
                    continue;
                
                
            
                while (curMoveLeft>=0 && curMoveRight<s.length() && s.charAt(curMoveLeft)==s.charAt(curMoveRight)) {
                    curMoveLeft-=1;
                    curMoveRight+=1;
                   

                }
                curMoveLeft+=1;
                curMoveRight-=1;

                if (curMoveRight+1-curMoveLeft > najvecaDuzina) {
                    najvecaDuzina = curMoveRight+1-curMoveLeft;
                    levo = curMoveLeft;
                    desno = curMoveRight;
                }
            }

        return s.substring(levo,desno+1);
    }
}
