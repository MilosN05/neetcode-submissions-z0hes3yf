class Solution {
    List<Integer>[] hash_list;
    int[] checked_elements;

    int number_of_components;

    public int countComponents(int n, int[][] edges) {
        checked_elements = new int[n];
        hash_list= new List[n];

        for (int i=0;i<n;i++)
            hash_list[i]=new ArrayList<>();
        
        for (int i=0;i<edges.length;i++) {
            hash_list[edges[i][0]].add(edges[i][1]);
            hash_list[edges[i][1]].add(edges[i][0]);

        }


        for (int i =0;i<n;i++) {
            if (checked_elements[i]==0) {
                // traverse_elements(i, -1, new HashSet<>());
                traverse_elements(i, -1);
                number_of_components+=1;
            }



        }



        return number_of_components;



    }


    private void traverse_elements(Integer cur_num, Integer prev_num ) {
        // if (!temp_set.contains(cur_num)) {
        //     temp_set.add(cur_num);
        //     checked_elements[cur_num]=1;

        // }
        if (checked_elements[cur_num]==0)
            checked_elements[cur_num]=1;
        else     
            return;

        List<Integer> adj_list = hash_list[cur_num];
        int len_adj_list = adj_list.size();


        for (int i=0;i<len_adj_list;i++) {
            if (prev_num == adj_list.get(i))
                continue;
            
            // traverse_elements(adj_list.get(i), cur_num, temp_set);
            traverse_elements(adj_list.get(i), cur_num);

        }



    }
}
