class Solution {
    List<List<Integer>> set_of_combinations;

    int start = 0;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums==null) return null;

        set_of_combinations = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(),target, 0);
        return set_of_combinations;

    }

    private void backtrack(int[] nums, List<Integer> combination,int target, int current_sum) {

        if (current_sum==target) {
            set_of_combinations.add(new ArrayList<>(combination));
            return;
        }

        else if (current_sum>target) {
            return;
        }

        for (int i=start;i<nums.length; i++) {
            start =i;

            combination.add(nums[i]);
            backtrack(nums, combination, target, current_sum+nums[i]);
            combination.remove(combination.getLast());
            if (current_sum+nums[i]>target || current_sum+nums[i]==target)
                break;
            

        }

       

    }
}
