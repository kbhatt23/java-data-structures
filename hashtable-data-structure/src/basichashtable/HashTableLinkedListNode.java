package basichashtable;

public class HashTableLinkedListNode<K,V> {
	private K key;
	private V value;
	private HashTableLinkedListNode<K, V> next;
	public HashTableLinkedListNode(K key, V value, HashTableLinkedListNode<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
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
	public HashTableLinkedListNode<K, V> getNext() {
		return next;
	}
	public void setNext(HashTableLinkedListNode<K, V> next) {
		this.next = next;
	}

}
