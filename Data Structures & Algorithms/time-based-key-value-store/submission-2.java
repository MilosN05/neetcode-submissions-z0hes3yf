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

            for (int i=pok.size()-1;i>=0;i--) {
                Pair ts = pok.get(i);
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