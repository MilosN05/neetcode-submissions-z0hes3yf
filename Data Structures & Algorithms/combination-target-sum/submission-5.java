class Solution {
    List<List<Integer>> combinations;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums==null)
            return null;

        combinations = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(),target, 0);
        return combinations;

    }

    private void backtrack(int sum, int[] nums, List<Integer> cur_comb , int target, int i) {
        if (sum==target) {
            combinations.add(new ArrayList<>(cur_comb));
            return;
        }
        if (i==nums.length || sum>target)
            return;


        cur_comb.add(nums[i]);
        backtrack(sum+nums[i], nums, cur_comb, target, i);
        cur_comb.remove(cur_comb.size()-1);
        backtrack(sum, nums, cur_comb, target, i+1);
    }
}
