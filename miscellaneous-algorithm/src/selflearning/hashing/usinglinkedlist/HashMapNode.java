package selflearning.hashing.usinglinkedlist;

public class HashMapNode<K,V> {

	private K key;
	private V value;
	private HashMapNode<K,V> next;
	public HashMapNode(K key, V value, HashMapNode<K, V> next) {
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
	public HashMapNode<K, V> getNext() {
		return next;
	}
	public void setNext(HashMapNode<K, V> next) {
		this.next = next;
	}
}
