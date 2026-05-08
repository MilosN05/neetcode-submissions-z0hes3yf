class TimeMap {

    HashMap<String, List<Pair>> hmp;

    public TimeMap() {
        hmp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair newPair = new Pair(value,timestamp);
        if (hmp.containsKey(key)) {
            hmp.get(key).add(newPair);
        }
        else {
            hmp.put(key, new ArrayList<>());
            hmp.get(key).add(newPair);
        }
    }

    public String get(String key, int timestamp) {
        if (hmp.containsKey(key)) {
            List<Pair> pok = hmp.get(key);
            Pair[] tempAr = new Pair[pok.size()];

            int brojac =0;
            for (Pair element: pok)
                tempAr[brojac++] = element;


            for (int i=tempAr.length-1;i>=0;i--) {
                Pair ts = tempAr[i];
                if (ts.timestamp<=timestamp)
                    return ts.value;
            }



        }
        return "";
    }
}

class Pair {
    String value;
    int timestamp;

    public Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}