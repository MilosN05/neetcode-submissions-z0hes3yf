class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        int i=0;
        List<List<String>> resenje = new LinkedList<>();
        while (i<strs.length) {
            List<String> trResenje;
            if (strs[i]!=null) {
                 trResenje= new LinkedList<>();
                 trResenje.add(strs[i]);



            for (int k=i+1;k<strs.length;k++) {
                if (isAnagram(strs[i], strs[k])) {
                    trResenje.add(strs[k]);
                    strs[k] = null;
                }

            }
                resenje.add(trResenje);
            }
            i++;

        }
        return resenje;
    }

    public boolean isAnagram(String s1, String s2) {

        if (s1==null || s2==null || s1.length()!=s2.length())
            return false;

        int[] slovaAnglosanksongkog = new int[26];
        for (int i=0;i<s1.length();i++) {
            slovaAnglosanksongkog[s1.charAt(i)-'a']++;
            slovaAnglosanksongkog[s2.charAt(i)-'a']--;
        }

        for (Integer element:slovaAnglosanksongkog) {
            if (element!=0)
                return false;
        }
        return true;
    }
}
