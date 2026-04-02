class Solution {
    public int evalRPN(String[] tokens) {
        List<Integer> stack = new ArrayList<>();


        int velicina =0;

        int zbir =0;
        for (String element: tokens) {
            try {
                stack.add(Integer.parseInt(element));

                velicina += 1;
            } catch (Exception e) {
                String znak = element;
                if (stack.size() == 1)
                    return stack.get(0);
                System.out.println(zbir);
                if (znak.equals("+")) {
                    zbir = stack.get(velicina - 2) + stack.get(velicina - 1);
                } else if (znak.equals("-")) {
                    zbir = stack.get(velicina - 2) - stack.get(velicina - 1);

                } else if (znak.equals("/")) {
                    zbir = stack.get(velicina - 2) / stack.get(velicina - 1);

                } else if (znak.equals("*")) {
                    zbir = stack.get(velicina - 2) * stack.get(velicina - 1);

                }
                stack.remove(velicina - 1);
                velicina--;
                stack.set(velicina - 1, zbir);
            }
        }

        if (stack.size()==1)
            return stack.get(0);
        return zbir;
    }

}