class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<List<Integer>> puta3 = new ArrayList<>();

        for (int i=0;i<9;i++)
            puta3.add(new ArrayList<>());
        for (int i =0;i<board.length;i++) {
            List<Integer> listaBrojeva = new LinkedList<>();
            List<Integer> proveraKolona = new LinkedList<>();
            for (int k=0;k<board[0].length;k++) {
                char element = board[i][k];
                char elKolona = board[k][i];


                int boxIndex = (i/3 *3 + k/3);

                if (element<48 && element!=46 || element >57 || elKolona<48  && elKolona!=46 || elKolona>57 )
                    return false;
                System.out.println(elKolona);

                if (listaBrojeva.contains((int) element) || proveraKolona.contains((int) elKolona) || puta3.get(boxIndex).contains((int)element))
                    return false;
                else {
                    if (element!=46) {
                        listaBrojeva.add((int) element);
                        puta3.get(boxIndex).add((int)element);
                    }
                    if (elKolona!=46)
                        proveraKolona.add((int) elKolona);

                }

            }

    }

        return true;
    }
}
