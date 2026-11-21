class Solution {
    public int countSubstrings(String s) {
         //pretraga samo neparnih palindroma
        String palindrome;


        int brojRazlicitihSubStringova=0;
        for (int i=0;i<s.length();i++) {
            int curMoveLeft =i-1;
            int curMoveRight = i+1;

            while (curMoveLeft>=0 && curMoveRight<s.length() &&  s.charAt(curMoveLeft)==s.charAt(curMoveRight)) {
                brojRazlicitihSubStringova+=1;
                curMoveLeft-=1;
                curMoveRight+=1;

            }
            curMoveLeft+=1;
            curMoveRight-=1;

            
            brojRazlicitihSubStringova+=1;    
            
                
           
        }

        if (s.length()>1)
            //pretraga parnih palindroma
            for (int i=0;i<s.length();i++) {
                int parOdI=i+1;
                int curMoveLeft =i-1;
                int curMoveRight = parOdI+1;
                
                if  (parOdI==s.length() || s.charAt(i)!=s.charAt(parOdI))
                    continue;
                else
                    brojRazlicitihSubStringova+=1;
                
                
            
                while (curMoveLeft>=0 && curMoveRight<s.length() && s.charAt(curMoveLeft)==s.charAt(curMoveRight)) {                   brojRazlicitihSubStringova+=1;
                    curMoveLeft-=1;
                    curMoveRight+=1;
                   

                }
                curMoveLeft+=1;
                curMoveRight-=1;


            }

        return brojRazlicitihSubStringova;
    }
}
