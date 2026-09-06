class Solution {
    HashMap<Integer, List<Integer>> hash_list;
    int[] checked_elements;

    int number_of_components;

    public int countComponents(int n, int[][] edges) {
        checked_elements = new int[n];
        hash_list = new HashMap<>();


        for (int i=0;i<n;i++)
            hash_list.put(i, new ArrayList<>());
        
        for (int i=0;i<edges.length;i++) {
            hash_list.get(edges[i][0]).add(edges[i][1]);
            hash_list.get(edges[i][1]).add(edges[i][0]);

        }


        for (int i =0;i<n;i++) {
            if (checked_elements[i]==0) {
                traverse_elements(i, -1, new HashSet<>());
                number_of_components+=1;
            }



        }



        return number_of_components;



    }


    private void traverse_elements(Integer cur_num, Integer prev_num, HashSet<Integer> temp_set) {
        checked_elements[cur_num]=1;
        if (!temp_set.contains(cur_num)) {
            temp_set.add(cur_num);
            
        }
        else     
            return;

        List<Integer> adj_list = hash_list.get(cur_num);
        int len_adj_list = adj_list.size();


        for (int i=0;i<len_adj_list;i++) {
            if (cur_num == adj_list.get(i))
                continue;
            
            traverse_elements(adj_list.get(i), cur_num, temp_set);
        }



    }
}
