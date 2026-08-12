class Solution {
    List<List<String>> palindromes;
    public List<List<String>> partition(String s) {
        if (s==null) return null;

        palindromes = new ArrayList<>();
        backtrack(s, 0,new ArrayList<>());


        return palindromes;


    }

    private void backtrack(String s, int i,List<String> p_palindrome) {
        if (i==s.length()) {
           palindromes.add(new ArrayList<>(p_palindrome));
            return;
        }

        for (int j=i+1; j<s.length()+1; j++) {
            String cur_str = s.substring(i,j);
            if (is_palindrome(cur_str)) {
                p_palindrome.add(cur_str);
                backtrack(s,j,p_palindrome);
                p_palindrome.remove(p_palindrome.size()-1);

            }
    }

    };


    private boolean is_palindrome(String str) {
        int length_str = str.length();
        for (int i =0; i<length_str-i-1;i++) {
            if (str.charAt(i)!=str.charAt(length_str-i-1))
                return false;
        }
        return true;
    }
}
