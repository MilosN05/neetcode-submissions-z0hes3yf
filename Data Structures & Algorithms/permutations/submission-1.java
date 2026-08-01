class Solution {
    
    List<List<Integer>> permutations;
    public List<List<Integer>> permute(int[] nums) {
        if (nums==null) return null;

        permutations = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return permutations;

    }


    private void backtrack(int[] nums, boolean[] selected_yn, List<Integer> selected_elements) {

        if (selected_elements.size()==nums.length) {
            permutations.add(new ArrayList<>(selected_elements));
            return;
        }

        for (int i =0; i<selected_yn.length; i++) {
            if (selected_yn[i]==false) {
                selected_elements.add(nums[i]);
                selected_yn[i]=true;
                backtrack(nums, selected_yn, selected_elements);
                selected_elements.remove(selected_elements.getLast());
                selected_yn[i] = false;
            }
            
        }
    }
}
