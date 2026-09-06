class Solution {
    HashMap<Integer, List<Integer>> hash_list;
    int[] checked_courses;
    int[] ordering;
    int num_in_ordering=-1;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        hash_list = new HashMap<>();
        checked_courses = new int[numCourses];
        ordering = new int[numCourses];
        num_in_ordering=0;

        for (int i =0 ;i<numCourses;i++)
            hash_list.put(i, new ArrayList<>());

        for (int i =0;i<prerequisites.length;i++) {
            hash_list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }


        boolean cycle_exists = find_order_help(0,null,true);

        return !cycle_exists ? new int[0]:ordering;
    }

    private boolean find_order_help(Integer cur_node, HashSet<Integer> temp_set, boolean start) {
        if (!start && temp_set.contains(cur_node))
            return false;

        if (!start)  {

            if (checked_courses[cur_node]==2)
                return true;
            temp_set.add(cur_node);

        }

        if (start) {
            int numCourses = hash_list.size();
            for (int i=0;i<numCourses; i++) {

                if (checked_courses[i]==0) {
                    temp_set = new HashSet<Integer>();
                    temp_set.add(i);

                    boolean t_value = algo_search(i, temp_set);

                    if (!t_value)
                        return false;
                }
            }

        }
        else {
            boolean t_value = algo_search(cur_node, temp_set);

            if (!t_value)
                return false;
        }


        return true;
    }

    private boolean algo_search(Integer cur_node, HashSet<Integer> temp_set) {
        List<Integer> adj_list = hash_list.get(cur_node);
        int len_adj_list = adj_list.size();

        for (int i =0;i<len_adj_list;i++) {


            boolean adding_el = find_order_help(adj_list.get(i),temp_set,false);

            if (!adding_el) {
                temp_set.remove(cur_node);
                return false;
            }
        }

        temp_set.remove(cur_node);
        checked_courses[cur_node]=2;
        ordering[num_in_ordering++]=cur_node;

        return true;
    }
}
