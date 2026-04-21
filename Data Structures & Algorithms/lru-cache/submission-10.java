class LRUCache {
    class Node {
        int value;
        int key;
        Node next;
        Node prev;

        Node(int value, int key) {
            this.value = value;
            this.key = key;
        }
    }


    HashMap<Integer, Node> hmp = new HashMap<>();
    Node lCvor;
    Node dCvor;
    int kapacitet;
    public LRUCache(int capacity) {
        kapacitet = capacity;
        lCvor= new Node(0,0);
        dCvor = new Node(0,0);
        lCvor.next = dCvor;
        dCvor.prev = lCvor;
    }


    public void remove(Node o) {
        Node prethodni = o.prev; Node naredni = o.next; 
        prethodni.next = naredni; naredni.prev = prethodni;
    }
    public void insert(Node o) {
        Node prethodni = dCvor.prev; Node naredni = dCvor;
        prethodni.next = o; naredni.prev = o;
        o.next=  naredni; o.prev= prethodni;
    }
    public int get(int key) {
        if (hmp.containsKey(key)) {
            remove(hmp.get(key));
            insert(hmp.get(key));
            return hmp.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {

        if (hmp.containsKey(key)) {
            remove(hmp.get(key));
            hmp.remove(key);
            
        }

        Node noviCvor = new Node(value,key);
        hmp.put(key,noviCvor);
        insert(noviCvor);

        if (hmp.size()>kapacitet) {
            Node lru = lCvor.next;
            hmp.remove(lru.key);
            remove(lru);
        }

    }
}
