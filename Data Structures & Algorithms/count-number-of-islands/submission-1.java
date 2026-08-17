class Solution {
    int num_islands;
    boolean[][] used_el_graph;
    public int numIslands(char[][] grid) {
        if (grid==null)
            return 0;

    used_el_graph = new boolean[grid.length][grid[0].length];

    recursive_dfs(grid,0,0,true);


    return num_islands;

        
    }

    private void recursive_dfs(char[][] grid, int i, int j, boolean start) {
        if (!start && (i>=grid.length  || i<0 || j<0  || j>=grid[0].length || grid[i][j]=='0'  || used_el_graph[i][j]  )) {
            return;
        }

        if (!start)
            used_el_graph[i][j]=true;

        if (start)
            for (int s=0;s<grid.length;s++)
                for (int k =0;k<grid[0].length;k++) {
                    if (grid[s][k]=='1' && !used_el_graph[s][k]) {
                        recursive_dfs(grid, s,k, false);
                        num_islands+=1;
                    }
                }

        else {
            //lijevo
           recursive_dfs(grid, i,j-1, false);
           //desno
           recursive_dfs(grid, i,j+1, false); 

           //gore
           recursive_dfs(grid, i-1,j, false); 

           //dole
           recursive_dfs(grid, i+1,j, false); 

        }
    }
}
