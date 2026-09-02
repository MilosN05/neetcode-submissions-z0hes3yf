class Solution {
    boolean[][] observed;
    public void solve(char[][] board) {
        if (board ==null || board[0].length==0) return;

        observed = new boolean[board.length][board[0].length];

        int rows = board.length;
        int cols = board[0].length;


        ///for zero's
        for (int i =0;i<rows;i++) {
            dfs_zero(board, i, 0,new boolean[board.length][board[0].length],true);
            dfs_zero(board, i, cols-1,new boolean[board.length][board[0].length],true);
        }

        for (int i =0;i<cols;i++) {
            dfs_zero(board, 0, i, new boolean[board.length][board[0].length],true);
            dfs_zero(board, rows-1, i, new boolean[board.length][board[0].length],true);
        }



        // dfs_nzero(board,0,0,true);

        for (int i =0; i<rows; i++)
            for (int k=0;k<cols;k++) {
                if (board[i][k]=='O' && !observed[i][k])
                    board[i][k]='X';
            }

        


    }


    private void dfs_zero(char[][] board, int i, int j, boolean[][] temp_observed, boolean start) {

        if (i<0 || j<0 || i==board.length || j==board[0].length || observed[i][j] || temp_observed[i][j])
            return;

        if (board[i][j]=='O') {
            temp_observed[i][j]=true;

            if (!start) {
                observed[i][j]=true;
            }
            
            dfs_zero(board,i, j-1, temp_observed, false);
            dfs_zero(board,i, j+1, temp_observed, false);
            dfs_zero(board,i-1, j, temp_observed, false);
            dfs_zero(board,i+1, j, temp_observed, false);


            if (start)
                observed[i][j]=true;

        }
        else
            return;


        
    };


}
