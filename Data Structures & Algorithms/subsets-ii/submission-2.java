class Solution {

    List<List<Integer>> all_subsets;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums==null) return null;
        Arrays.sort(nums);

        all_subsets = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0);

        return all_subsets;
    }

    private void backtrack(int[] nums, List<Integer> subset, int index) {
        all_subsets.add(new ArrayList<>(subset));

        for (int i =index; i<nums.length;i++) {
            
            if ( i> index && (nums[i]==nums[i-1]))
                continue;
           

            subset.add(nums[i]);
            backtrack(nums,subset, i+1);
            subset.remove(subset.getLast());
        }
    }
}
