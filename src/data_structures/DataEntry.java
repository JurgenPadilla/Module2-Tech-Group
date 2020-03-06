package data_structures;

public class DataEntry<K, V> {
    private K key;
    private V value;

    public DataEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof DataEntry) {
            DataEntry entryToCompare = (DataEntry) object;
            return this.key.equals(entryToCompare.getKey());
        }
        return false;
    }

}
