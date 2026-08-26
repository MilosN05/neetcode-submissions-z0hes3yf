class Solution {
    
    Queue<List<Integer>> cur_queue;
    List<List<Integer>> all_coords;
    boolean[] temp_co_oceans;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights ==null || heights.length==0)
            return null;

        
        all_coords = new ArrayList<>();
        cur_queue = new LinkedList<>();
        temp_co_oceans = new boolean[2];


        for (int i =0;i<heights.length;i++)
            for (int k =0;k<heights[0].length;k++) {

                boolean[][] crossed_el =  new boolean[heights.length][heights[0].length];
                List<Integer> comb = new ArrayList<>();
                comb.add(i);
                comb.add(k);

                cur_queue.add(comb);

                while (!cur_queue.isEmpty()) {
                    int queue_size = cur_queue.size();
                    for (int s=0;s<queue_size;s++) {
                        List<Integer> res = cur_queue.poll();

                        pacific_helper(heights,res.get(0)-1,res.get(1),heights[res.get(0)][res.get(1)], crossed_el);
                        pacific_helper(heights,res.get(0)+1,res.get(1),heights[res.get(0)][res.get(1)], crossed_el);
                        pacific_helper(heights,res.get(0),res.get(1)-1,heights[res.get(0)][res.get(1)], crossed_el);
                        pacific_helper(heights,res.get(0),res.get(1)+1,heights[res.get(0)][res.get(1)], crossed_el);

                    }
                }

                if (temp_co_oceans[0] && temp_co_oceans[1])
                    all_coords.add(comb);

                temp_co_oceans[0] =false;
                temp_co_oceans[1] =false;

            }



        return all_coords;
    }   

    public void pacific_helper(int[][] heights, int i, int j, int cur_value, boolean[][] crossed_el) {
        
        
        if ( i<0 || j<0 ) {
            temp_co_oceans[0]=true;
            return;
            }
        else if (i==heights.length || j==heights[0].length) {
            temp_co_oceans[1]=true;
            return;
        }

        if (crossed_el[i][j] || heights[i][j]>cur_value)
            return;

        crossed_el[i][j]=true;

        List<Integer> comb = new ArrayList<>();
                comb.add(i);
                comb.add(j);
        cur_queue.add(comb);

    }
}
