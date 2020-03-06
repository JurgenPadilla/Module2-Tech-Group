package data_structures;

public class MyHashMap<K, V> {
    private static final int LIST_SIZE_LIMIT = 3;
    private static final int INIT_ARRAY_SIZE = 10;
    private double loadFactor;

    private DoublyCircularLinkedList<DataEntry<K, V>>[] index;
    private int indexSize;

    private int size;

    public MyHashMap() {
        this.init(INIT_ARRAY_SIZE);
        this.loadFactor = 1;
    }

    public MyHashMap(int initArraySize) {
        this.init(initArraySize);
        this.loadFactor = 1;
    }

    public MyHashMap(int initArraySize, double loadFactor) {
        this.init(initArraySize);
        this.loadFactor = loadFactor;
    }

    private void init(int indexSize) {
        this.indexSize = indexSize;
        this.index = new DoublyCircularLinkedList[this.indexSize];
        initArrayLists(this.index);
    }

    private void initArrayLists(DoublyCircularLinkedList[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = new DoublyCircularLinkedList<>();
        }
    }

    private static int getHashCode(Object value) {
        if (value instanceof String) {
            return value.toString().length();
        }

        return value.hashCode();
    }

    public int getIndexSize() {
        return this.indexSize;
    }

    public DoublyCircularLinkedList<DataEntry<K, V>> get(int index) {
        if (this.indexSize <= index) {
            throw new ArrayIndexOutOfBoundsException("Nono");
        }
        return this.index[index];
    }

    public V get(K key) {
        int hashKey = getHashCode(key) % this.indexSize;
        DoublyCircularLinkedList<DataEntry<K, V>> currentList = this.index[hashKey];
        for (int i = 0; i < currentList.size(); i++) {
            DataEntry<K, V> currentItem = currentList.get(i);
            if (currentItem.getKey().equals(key)) {
                return currentItem.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int hashKey = getHashCode(key) % this.indexSize;
        DataEntry<K, Object> entry = new DataEntry<>(key, null);

        return contains(this.index, entry, hashKey);
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < this.indexSize; i++) {
            for (int j = 0; j < this.index[i].size(); j++) {
                if (value.equals(this.index[i].get(j).getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean contains(DoublyCircularLinkedList[] array, Object newValue, int hashKey) {
        DoublyCircularLinkedList currentList = array[hashKey];

        return currentList.contains(newValue);
    }

    public boolean put(K key, V value) {
        int hashKey = getHashCode(key) % this.indexSize;

        DataEntry<K, V> newEntry = new DataEntry<>(key, value);
        boolean result = add(this.index, newEntry, hashKey);

        if (result) {
            DoublyCircularLinkedList currentList = this.index[hashKey];
            this.size++;
            if ((double) this.size / this.index.length > loadFactor) {

                rearrangeSet();
            }
//            if (currentList.size() > LIST_SIZE_LIMIT /*LOAD_FACTOR > THISINDEXSIZSE/SIZE*/) {
//                rearrangeSet();
//            }
//            this.size++;
        }
        return result;
    }

    private static boolean add(DoublyCircularLinkedList[] currentArray, Object newEntry, int hashKey) {
        DoublyCircularLinkedList currentList = currentArray[hashKey];
        if (contains(currentArray, newEntry, hashKey)) {
            currentList.remove(newEntry);
        }

        currentList.add(newEntry);

        return true;
    }

    private void rearrangeSet() {
        this.indexSize *= 2;
        DoublyCircularLinkedList<DataEntry<K, V>>[] newIndex = new DoublyCircularLinkedList[this.indexSize];
        initArrayLists(newIndex);

        for (DoublyCircularLinkedList<DataEntry<K, V>> currentList : this.index) {
            for (int i = 0; i < currentList.size(); ++i) {
                DataEntry<K, V> currentItem = currentList.get(i);
                int hashKey = getHashCode(currentItem.getKey()) % newIndex.length;
                add(newIndex, currentItem, hashKey);
            }
        }
        this.index = newIndex;
    }

    public int size() {
        return this.size;
    }

    public boolean remove(K key) {
        int hashKey = getHashCode(key) % this.indexSize;
        DataEntry<K, V> newEntry = new DataEntry<>(key, null);
        return this.index[hashKey].remove(newEntry);
    }
}
