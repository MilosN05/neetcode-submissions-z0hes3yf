class Solution {

    HashMap<Integer, List<Integer>> adj_hash;
    int[] checked_courses;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj_hash = new HashMap<>();
        checked_courses = new int[numCourses];

        //Inicijalizacija listi susedstva
        for (int i=0;i<numCourses;i++) {
            adj_hash.put(i,new ArrayList<>());
        }

        ///Popunjavanje liste susedstva
        for (int i =0; i<prerequisites.length; i++) 
            adj_hash.get(prerequisites[i][0]).add(prerequisites[i][1]);

        return canFinish_helper(0, null, true);

        
        
    }

    private boolean canFinish_helper(Integer cur_node, HashSet<Integer> temp_set, boolean start) {
        if (!start && temp_set.contains(cur_node))
            return false;
        
        if (!start) {
            if (checked_courses[cur_node]==2)
                return true;
            temp_set.add(cur_node);
        }


        if (start)
            for (int i =0;i<adj_hash.size(); i++) {
                temp_set = new HashSet<>();


                if (checked_courses[i]==0) {
                    temp_set.add(i);
                    boolean t_value = add_element(i, temp_set);
                    if (!t_value)
                        return false;

                }
                // else {
                //     checked_courses[i]=2;
                // }
              
            }
        else {
            boolean t_value = add_element(cur_node, temp_set);

            // temp_set.remove(cur_node);
            if (!t_value)
                return false;
        }
        

        return true;
    }

    private boolean add_element(Integer cur_node, HashSet<Integer> temp_set) {
        List<Integer> adj_list = adj_hash.get(cur_node);
        int length_adj = adj_list.size();
        for (int j=0;j<length_adj;j++) {
            boolean t_value = canFinish_helper(adj_list.get(j), temp_set, false);

            if (!t_value) {
                temp_set.remove(cur_node);

                return false;
                }
        } 
        temp_set.remove(cur_node);

        checked_courses[cur_node]=2;
        return true;
    }
}
