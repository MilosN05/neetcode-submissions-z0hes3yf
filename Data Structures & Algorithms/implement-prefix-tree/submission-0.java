

class TrieNode_Moj {
    char slovo;
    boolean da_li_je_kraj_stringa;
    TrieNode_Moj[] abeceda;

    public TrieNode_Moj(char slovo) {
        this.slovo = slovo;
        abeceda = new TrieNode_Moj[26]  ;
    }

    public TrieNode_Moj dete_abecede(char slovo) {
        if (abeceda !=null) {
            for (TrieNode_Moj slovo_u_nizu: abeceda) {
                if (slovo_u_nizu!=null && slovo_u_nizu.slovo==slovo)
                    return slovo_u_nizu;
            }
        }
        return null;
    }

}

class PrefixTree {
    private final TrieNode_Moj root;
    public PrefixTree() {
        root = new TrieNode_Moj(' ');

    }

    public void insert(String word) {
        TrieNode_Moj kopija = root;

        for (int i =0; i<word.length();i++) {
            char t_karakter = word.charAt(i);
            if (kopija.abeceda[t_karakter - 97] == null) {
                kopija.abeceda[t_karakter - 97] = new TrieNode_Moj(t_karakter);
            }
            kopija = kopija.dete_abecede(t_karakter);
        }
        kopija.da_li_je_kraj_stringa = true;
    }

    public boolean search(String word) {
        TrieNode_Moj kopija = root;
        for (int i=0; i<word.length();i++) {

            kopija = kopija.dete_abecede(word.charAt(i));
            if (kopija==null)
                return false;
        }

        return kopija.da_li_je_kraj_stringa;
    }

    public boolean startsWith(String prefix) {
        TrieNode_Moj kopija = root;
        for (int i=0; i<prefix.length();i++) {
            kopija = kopija.dete_abecede(prefix.charAt(i));
            if (kopija==null)
                return false;
        }
        return true;
    }
}
