class Solution {
    public int lengthOfLongestSubstring(String s) {
        int levo =0, desno=0, duzina = s.length();
        Set<Character> set = new HashSet<>();
        int trenutno = 0, max=0;
        while (desno<duzina) {
            char karakter = s.charAt(desno);
            while (set.contains(karakter)) {
                set.remove(s.charAt(levo));
                levo++;
                trenutno-=1;
            }

            trenutno+=1;
            if (trenutno>max)
                max=trenutno;

            set.add(karakter);
            desno++;

        }
        return max;
    }
}
