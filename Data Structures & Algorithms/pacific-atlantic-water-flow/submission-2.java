class Solution {
    HashSet<Integer> set_p;
    HashSet<Integer> set_a;
    boolean[][] visited_p;
    boolean[][] visited_a;
    List<List<Integer>> result;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights==null || heights[0].length==0) return null;
        

        int rows = heights.length;
        int cols = heights[0].length;

        set_p=  new HashSet<>();
        set_a=  new HashSet<>();
        visited_p = new boolean[rows][cols];
        visited_a = new boolean[rows][cols];
        result = new ArrayList<>();

        

        for (int i=0;i<rows;i++) {
            dfs(heights,set_p,i, 0,heights[i][0], true);
            dfs(heights,set_a,i, cols-1,heights[i][cols-1], false);
        }

        for (int i=0;i<cols;i++) {
            dfs(heights,set_p,0,i,heights[0][i], true);
            dfs(heights,set_a,rows-1,i,heights[rows-1][i], false);
        }

        System.out.println(set_p.contains(2));
        System.out.println(set_a.contains(2));
        for (int i=0;i<heights.length;i++)
            for (int j=0;j<heights[0].length;j++) {
                if (set_p.contains(i*heights[0].length+j) && set_a.contains(i*heights[0].length+j)) {
                    List<Integer> comb = new ArrayList<>();
                    System.out.println("i: " + i + " j: " +j);
                    comb.add(i);
                    comb.add(j);
                    result.add(comb);
                    
                }
                    
            }

        return result;

    }

    private void dfs(int[][]heights, HashSet<Integer> set, int i,int j, int prev_el, boolean pf) {
        if (i<0 || j<0 || i==heights.length || j==heights[0].length ||  (pf && visited_p[i][j] ) || (pf==false && visited_a[i][j] )|| prev_el>heights[i][j])
            return;

        if (pf)
            visited_p[i][j]=true;
        else 
            visited_a[i][j]=true;
        set.add(i*heights[0].length+j);
        dfs(heights,set, i-1,j, heights[i][j],pf);
        dfs(heights,set, i+1,j, heights[i][j],pf);
        dfs(heights,set, i,j-1, heights[i][j],pf);
        dfs(heights,set, i,j+1, heights[i][j],pf);
    }





    
}
