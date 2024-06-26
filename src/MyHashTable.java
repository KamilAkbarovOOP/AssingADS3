public class MyHashTable <K, V>{
    static class HashNode <K, V>{
        private K key;
        private V value;
        public HashNode<K, V> next;
        public HashNode (K key, V value) {
            this.key = key;
            this.value = value;
        }
        public String toString(){
            return key + " " + value ;
        }
    }


    HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;


    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }
    public MyHashTable (int M){
        this.M = M;
        this.chainArray = new HashNode[M];
        size = 0;
    }

    public int size(){
        return size;
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value){
        HashNode<K, V> node = (HashNode<K, V>) get(key);
        if(node != null){
            node.value = value;
            return;
        }

        int index = hash(key);
        HashNode<K, V> newnode = new HashNode<>(key, value);
        if(chainArray[index] == null){
            chainArray[index] = newnode;
        }
        else{
            newnode.next = chainArray[index];
            chainArray[index] = newnode;
        }
        size++;
    }

    public V get (K key){
        int hash = hash(key);
        HashNode<K, V> current = chainArray[hash];
        while (current.next != null){
            if(((Comparable)current.key).compareTo(key) > 0){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key){
        int hash = hash(key);
        HashNode<K, V> current = chainArray[hash];
        HashNode<K, V> prev = null;
        while (current.next != null){
            if(((Comparable)current.key).compareTo(key) > 0){
                if (prev == null){
                    chainArray[hash] = current.next;
                }
                else{
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }

    public boolean contains(V value){
        for (HashNode <K, V> node : chainArray){
            HashNode <K, V> current = node;
            while (current.next != null) {
                if (((Comparable) current.value).compareTo(value) > 0) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public K getKey (V value){
        for (HashNode <K, V> node : chainArray){
            HashNode <K, V> current = node;
            while (current.next != null) {
                if (((Comparable) current.value).compareTo(value) > 0) {
                    return node.key;
                }
                current = current.next;
            }
        }
        return null;
    }

}
