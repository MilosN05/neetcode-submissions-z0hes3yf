class TrieNode {
    char slovo;
    boolean kraj_stringa;
    TrieNode[] alphabet;

    public TrieNode(char slovo) {
        this.slovo = slovo;
        alphabet = new TrieNode[26];
    }

    public TrieNode pretrazi_slovo(char slovo) {
        if (alphabet!=null ) {
            for (TrieNode slovo_alphabeta:alphabet) {
                if (slovo_alphabeta!=null && slovo_alphabeta.slovo == slovo)
                    return slovo_alphabeta;
            }
        }

        return null;
    }

}


class WordDictionary {
    

    TrieNode koren;

    public WordDictionary() {
        koren = new TrieNode(' ');
    }

    public void addWord(String word) {
        TrieNode kopija = koren;
        for (int i=0; i< word.length(); i++) {
            char trazeno_slovo = word.charAt(i);
            if (kopija.pretrazi_slovo(trazeno_slovo) == null) {
                kopija.alphabet[trazeno_slovo-97] = new TrieNode(trazeno_slovo);
            }
            kopija = kopija.alphabet[trazeno_slovo-97];
           
        }

        kopija.kraj_stringa = true;
    }

    public boolean search(String word) {
        return search_helper(koren, word, 0);
    }

    private boolean search_helper(TrieNode koren, String word, int index) {
        if (koren==null ) return false;
        
        int duzina_reci = word.length();

        if (index==duzina_reci && koren.kraj_stringa == true) return true;
        else if (index==duzina_reci) return false;

        char trazeno_slovo = word.charAt(index);

        if (trazeno_slovo=='.') {
            boolean da_li_postoji = false;
            for (int i=0; i<26;i++)  {
                da_li_postoji = search_helper(koren.alphabet[i], word, index+1);
                if (da_li_postoji)
                    return true;
            }
            return false;

        }
        return search_helper(koren.pretrazi_slovo(trazeno_slovo), word, index+1);
    }
}
