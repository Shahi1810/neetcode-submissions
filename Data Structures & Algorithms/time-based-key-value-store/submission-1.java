class TimeMap {

    private HashMap<String, Map<Integer,String>> keyStore;
    
    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!keyStore.containsKey(key)){
            keyStore.put(key,new HashMap<>());
        }
        if(!keyStore.get(key).containsKey(timestamp)){
            keyStore.get(key).put(timestamp, "");
        }
        keyStore.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!keyStore.containsKey(key)){
            return "";
        }
        int seen = -1;
        for(int time : keyStore.get(key).keySet()){
            if(time<=timestamp)
            seen = Math.max(seen,time);
        }

        if(seen == -1) return "";
        return keyStore.get(key).get(seen);
    }
}
