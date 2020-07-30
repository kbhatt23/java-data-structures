package basichashtable;

public class LinearProbingNode<K,V> {

	public LinearProbingNode(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	private K key;
	private V value;
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
}
