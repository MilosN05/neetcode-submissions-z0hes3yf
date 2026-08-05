class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        if (n<=0) return null;

        result = new ArrayList<>();
        backtrack(n, 0,0, new StringBuilder());

        return result;
    }

    private void backtrack(int n, int num_op,int num_cl, StringBuilder cur_string) {
        if ((num_op ==n) && (num_cl==n)) {
            result.add(cur_string.toString());
            return;
        }


        for (int i =0;i<2;i++) {
            

            if (i>0 && num_op==0) 
                continue;
            else if (num_op==0 ) {
                cur_string.append('(');
                backtrack(n, num_op+1, num_cl, cur_string);  
                cur_string.deleteCharAt(cur_string.length()-1);

            } 
            else if (i==0 && num_op<n) {
                cur_string.append('(');
                backtrack(n, num_op+1, num_cl, cur_string);  
                cur_string.deleteCharAt(cur_string.length()-1);


            }
            else if (i==1 && num_op>num_cl){
                cur_string.append(')');
                backtrack(n, num_op, num_cl+1, cur_string);  
                cur_string.deleteCharAt(cur_string.length()-1);

            }


        }

        


             

    }
}
