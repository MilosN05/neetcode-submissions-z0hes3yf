class Solution {
    Queue<Integer[]> cur_queue;
    boolean[][] crossed_el;
    int required_mins;

    public int orangesRotting(int[][] grid) {
        if (grid==null || grid[0].length==0)
            return -1;


        cur_queue = new LinkedList<>();
        crossed_el = new boolean[grid.length][grid[0].length];


        int number_fresh_fr = 0;

        for (int i=0;i<grid.length;i++)
            for (int k=0;k<grid[0].length;k++)
                if (grid[i][k]==2) {
                    cur_queue.add(new Integer[]{i,k});
                    crossed_el[i][k]=true;
                }
                else if (grid[i][k]==1)
                    number_fresh_fr+=1;

        while (!cur_queue.isEmpty()) {
            int cur_size = cur_queue.size();



            for (int i=0;i<cur_size;i++) {
                Integer[] position = cur_queue.poll();
                
                int n_row = position[0];
                int n_col = position[1];

                if (grid[n_row][n_col]!=2)
                    number_fresh_fr-=1;


                oranges_helper(grid,n_row,n_col-1);
                oranges_helper(grid,n_row,n_col+1);
                oranges_helper(grid,n_row-1,n_col);
                oranges_helper(grid,n_row+1,n_col);

            }


            
            if (!cur_queue.isEmpty())
                required_mins+=1;
        }


        return number_fresh_fr>0 ? -1:required_mins;
    }


    private void oranges_helper(int[][] grid, int i, int j) {
        if (i<0 || i==grid.length || j<0 || j==grid[0].length || grid[i][j]==0 || crossed_el[i][j] )
            return;

        cur_queue.add(new Integer[]{i,j});
        crossed_el[i][j]=true;
    }
}
