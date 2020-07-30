package util;

public interface IHashTable<K, V> {
	int size();

	boolean isEmpty();
//not adding below as regrowing will depend upon load balancing factor
//l.b means how much stoarge array indices are used andhow much is left

	void put(K key, V value);

	V get(K key);
	
	V remove(K key);
}
