class Solution {
    int max_area;
    int cur_area;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid==null) return 0;


        area_calculation(grid,0,0,true);


        return max_area;
    }

    private void area_calculation(int[][] grid, int i, int j, boolean start) {

        if (!start && (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0))
            return;

        
        if (!start) {
            grid[i][j]=0;
            cur_area+=1;

            if (cur_area>max_area)
                max_area = cur_area;
        }

        if (start) 
            for (int v=0;v<grid.length;v++) 
                for (int k =0;k<grid[0].length;k++) {
                    if (grid[v][k]==1)
                        area_calculation(grid, v,k, false);
                    cur_area=0;
                }

        else {
            //gore
            area_calculation(grid, i-1,j, false);
            //dole
            area_calculation(grid, i+1,j, false);
            //levo
            area_calculation(grid, i,j-1, false);
            //desno
            area_calculation(grid, i,j+1, false);
        }
    }
}
