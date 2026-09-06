class Solution {
    HashMap<Integer, List<Integer>> hash_list;
    int checked =0;
    public boolean validTree(int n, int[][] edges) {



        ///provera povezanosti neorijentisanog grafa
        
        System.out.println("33");

        ///konverzija lista grana u liste susedstva
        hash_list = new HashMap<>();

        for (int i =0;i<n;i++)
            hash_list.put(i, new ArrayList<>());

        for (int i =0;i<edges.length;i++) {
            hash_list.get(edges[i][0]).add(edges[i][1]);
            hash_list.get(edges[i][1]).add(edges[i][0]);
        }

        ///da li postoji kontura/ciklus

        return is_cycle(0,-1, new HashSet<>(), edges) && checked==n;


    }


    public boolean is_cycle(Integer cur_num, Integer prev_num,HashSet<Integer> temp_set,int[][] edges) {


        if (!temp_set.contains(cur_num)) {
            temp_set.add(cur_num);
            checked+=1;
        }
        else
            return false;
            
        List<Integer> adj_list = hash_list.get(cur_num);
        int len_adj_list = adj_list.size();

        

        for (int i=0;i<len_adj_list;i++){
            if (prev_num==adj_list.get(i))
                continue;
            

            boolean is_c = is_cycle(adj_list.get(i), cur_num, temp_set, edges);
            if (!is_c)
                return false;
        }


        return true;

    }

    

}
