class Solution {
    Queue<Integer[]> some_queue;
    boolean[][] crossed_elements;
    public void islandsAndTreasure(int[][] grid) {
        if (grid==null || grid.length ==0)
            return;
        some_queue = new LinkedList<>();
        crossed_elements = new boolean[grid.length][grid[0].length];

        
        
        for (int s =0;s<grid.length;s++)
            for (int k =0;k<grid[0].length;k++) {
                if (grid[s][k]==0) {
                    some_queue.add(new Integer[]{s,k});
                    crossed_elements[s][k]=true;
                }
            }

        int crossed=0;
        while(!some_queue.isEmpty()) {

            int cur_size_oq=some_queue.size();
            for (int i=0;i<cur_size_oq;i++) {
                Integer[] unpacked = some_queue.poll();
            
                int n_row = unpacked[0];
                int n_col = unpacked[1];
                grid[n_row][n_col]=crossed;

                islands_help(grid,n_row,n_col-1);
                islands_help(grid,n_row,n_col+1);
                islands_help(grid,n_row-1,n_col);
                islands_help(grid,n_row+1,n_col); 
            }

            crossed+=1;
           
        }

        
        

    }


    private void islands_help(int[][] grid, int i, int j) {
        
        if (i<0 || i==grid.length || j<0 || j==grid[0].length || crossed_elements[i][j] || grid[i][j]==-1)
            return;

        some_queue.add(new Integer[]{i,j});
        crossed_elements[i][j]=true;

    }
}
