class Solution {
    List<List<Integer>> required_subsets = new LinkedList<>();;
    public List<List<Integer>> subsets(int[] nums) {
        if (nums==null) return null;

        backtrack(nums,new LinkedList<>(), 0);
        return required_subsets;
    }

    public void backtrack(int[] nums, LinkedList<Integer> subset,int index) {

        if (nums.length==index) {
                required_subsets.add(new LinkedList<>(subset));

            return;
        }

        subset.add(nums[index]);
        backtrack(nums,subset,index+1);

        subset.remove(subset.getLast());
        backtrack(nums,subset,index+1);

    }
}
