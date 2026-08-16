class Solution {

    List<List<Integer>> combinations;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates==null) return null;

        combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>());

        return combinations;
    }

    private void backtrack(int[] candidates, int target, int index, int cur_sum, List<Integer> combination) {

        if (cur_sum==target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }


        

        for (int i =index;i<candidates.length;i++) {
            
            if (i>index && candidates[i]==candidates[i-1])
                continue;

            if (cur_sum + candidates[i]>target)
                return;

            combination.add(candidates[i]);
            backtrack(candidates,target,i+1, cur_sum+candidates[i],combination);
            combination.remove(combination.size() -1);
        }


        

        
        
    }
}
