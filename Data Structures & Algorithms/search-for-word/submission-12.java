class Solution {
    HashSet<String> pos_grid;
    public boolean exist(char[][] board, String word) {
        if (word==null || board==null) return false;

        pos_grid = new HashSet<>();
        return backtrack(board, word, 0,0, 0, true);
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index, boolean pocetak) {
  

        if (i>=board.length || j>=board[0].length || i<0 || j< 0|| (pos_grid.contains(i+":"+j) ))
            return false;
        

        if (pocetak==true) {}
        else if (board[i][j]==word.charAt(index)) {
            pos_grid.add(i+":"+j);
            index+=1;
        }
        else 
            return false;

        if (index==word.length())
            return true;
        
    
        if (index==0) {
            for (int v=0;v<board.length;v++)
                for (int k=0;k<board[0].length;k++) {
                    if (board[v][k]==word.charAt(0)) {
                        boolean resenje = backtrack(board, word, v,k, index, false);
                        pos_grid.remove(v+":"+k);
                        if (resenje==true)
                            return true;
                        }
                }
            }

        else {
            
            boolean levo = backtrack(board,word,i,j-1,index, false);
            if (levo)
                return true;
            boolean desno = backtrack(board,word,i,j+1,index, false);
            if (desno)
                return true;
            boolean gore = backtrack(board,word,i-1,j,index, false);
            if (gore)
                return true;
            boolean dole = backtrack(board,word,i+1,j,index, false);
            if (dole)
                return true;
       

            ///pos_grid.remove je problem to popravljaj, pogeldaj sta ti gemini pise
            
        }
        pos_grid.remove(i+":"+j);
        return false;
    }
}
