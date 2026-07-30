class Solution {
    List<List<Integer>> required_subsets;
    public List<List<Integer>> subsets(int[] nums) {
        if (nums==null) return null;

        required_subsets = new ArrayList<>();
        backtrack(nums,new ArrayList<>(), 0);
        return required_subsets;
    }

    public void backtrack(int[] nums, List<Integer> subset,int index) {

        if (nums.length==index) {
            required_subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        backtrack(nums,subset,index+1);

        subset.remove(subset.getLast());
        backtrack(nums,subset,index+1);

    }
}
