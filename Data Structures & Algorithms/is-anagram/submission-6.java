class Solution {
  public boolean isAnagram(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if (lenS!=lenT)
            return false;

        int[] slovaAnglosaksonskog = new int[26];
        for (int i=0;i<lenS;i++) {

            slovaAnglosaksonskog[s.charAt(i) - 'a']++;
            slovaAnglosaksonskog[t.charAt(i)- 'a']--;

        }


        for (Integer element:slovaAnglosaksonskog) {
            if (element!=0)
                return false;
        }

        return true;
    }
}

