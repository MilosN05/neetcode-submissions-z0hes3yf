class Solution {

    class UnionElement {
        int value;
        UnionElement parent;

        UnionElement(int value, UnionElement parent) {
            this.value = value;
            this.parent = parent;
        }

    }

    class UnionFindRank {
        UnionElement[] elements;
        int[] elements_rank;
        UnionFindRank(int n) {
            elements = new UnionElement[n];
            elements_rank = new int[n];

            for (int i=0;i<n;i++) {
                UnionElement novi_element = new UnionElement(i+1, null);
                novi_element.parent = novi_element;
                elements[i]=novi_element;
            }
        }
        UnionElement find(UnionElement x) {
            if (x!=x.parent)
                x.parent = find(x.parent);
            return x.parent;
        }

        boolean union(UnionElement x, UnionElement y) {
            UnionElement x_root = find(x);
            UnionElement y_root = find(y);

            if (x_root==y_root)
                return true;
            if (elements_rank[x_root.value-1]>elements_rank[y_root.value-1]) 
                y_root.parent = x_root;
            else if (elements_rank[x_root.value-1]<elements_rank[y_root.value-1])
                x_root.parent = y_root;
        
            else {
                y_root.parent = x_root;
                elements_rank[x_root.value-1]+=1;
            }
            return false;

        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] zaIzbaciti = null;
        UnionFindRank unijaGrana = new UnionFindRank(edges.length);
        for (int i=0;i<edges.length;i++) {
            UnionElement x = unijaGrana.elements[edges[i][0]-1];
            UnionElement y = unijaGrana.elements[edges[i][1]-1];
            boolean elementVecDodat = unijaGrana.union(x,y);
            if (elementVecDodat) {
                zaIzbaciti = edges[i];
                break;
            }
                
        }

        return zaIzbaciti;
    }
}
