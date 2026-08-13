class Solution {
    HashMap<Integer, char[]> digits_ascii = new HashMap<>();
    List<String> combinations;

    public Solution() {
        // char char_number = 97;
        // for (int i =2;i<10;i++) {
        //     char[] char_d;
        //     if (i==7 || i==9) {
        //         char_d = new char[4];
        //         for (int k =0;k<4;k++) {
        //             char_d[k]=char_number++;
        //             System.out.println(char_d[k] + " " + i);
        //         }
        //     }

        //     char_d = new char[3];
        //     for (int k =0;k<3;k++) {
        //         char_d[k]=char_number++;
        //     }
        //     digits_ascii.put(i, char_d);

        // }

        digits_ascii.put(2, new char[]{'a','b','c'});
        digits_ascii.put(3, new char[]{'d','e','f'});
        digits_ascii.put(4, new char[]{'g','h','i'});
        digits_ascii.put(5, new char[]{'j','k','l'});
        digits_ascii.put(6, new char[]{'m','n','o'});
        digits_ascii.put(7, new char[]{'p','q','r','s'});
        digits_ascii.put(8, new char[]{'t','u','v'});
        digits_ascii.put(9, new char[]{'w','x','y','z'});



        //Moglo je samo digits_ascii.add(2, ...) pa digits_ascii.add(3,...) ali kao aj ovako, IAKO UOPSTE NIJE MORALO
    }
    public List<String> letterCombinations(String digits) {
        if (digits==null)
            return null;
        if (digits.isEmpty())
            return new ArrayList<>();

        combinations = new ArrayList<>();
        backtrack(digits, 0, "");
        
        return combinations;

        
    }


    private void backtrack(String given_digits, int index, String combination) {
        if (index==given_digits.length()) {
            combinations.add(combination);
            return;
        }
        int number_to_evaluate = given_digits.charAt(index) - 48;
        char[] required_d_ascii = digits_ascii.get(number_to_evaluate);


        for (int i =0; i<required_d_ascii.length;i++) {
            combination += required_d_ascii[i];
            backtrack(given_digits, index+1, combination);
            combination = combination.substring(0, combination.length()-1);
        }   


    }
}
