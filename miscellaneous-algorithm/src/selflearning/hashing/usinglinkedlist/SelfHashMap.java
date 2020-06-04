package selflearning.hashing.usinglinkedlist;

import selflearning.hashing.utility.StringHashingUtility;

public class SelfHashMap<K, V> {

	private Object[] dataSotrage;

	public SelfHashMap(int size) {
		dataSotrage = new HashMapNode[size];
	}

	public void insert(K key, V value) {
		int index = calculateHash(key);
		if (dataSotrage[index] == null) {
			// first time entry
			System.out
					.println("index have no collision at index " + index + " with key " + key + " and value " + value);
			dataSotrage[index] = new HashMapNode<K, V>(key, value, null);
		} else {
			HashMapNode<K, V> headNode = (HashMapNode<K, V>) dataSotrage[index];

			while (true) {
				// adding item at the last
				if (headNode.getNext() == null) {
					System.out.println("collision is there for index " + index + " with key " + key + " and value "
							+ value + " creating node after " + headNode.getValue());
					headNode.setNext(new HashMapNode<K, V>(key, value, null));
					return;
				}
				headNode = headNode.getNext();
			}
		}
	}

	public void delete(K key) {
		int index = calculateHash(key);
		HashMapNode<K, V> object = (HashMapNode<K, V>) dataSotrage[index];
		if (object != null) {
			// first time entry
			if (object.getKey().equals(key)) {
				dataSotrage[index] = null;
			} else {
				HashMapNode<K, V> headNode = object.getNext();
				HashMapNode<K, V> previousNode = object;
				while (true) {
					if (headNode == null) {
						break;
					}
					// adding item at the last
					if (headNode.getKey().equals(key)) {
						previousNode.setNext(null);
						return;
					}
					previousNode = headNode;
					headNode = headNode.getNext();
				}
			}
		}
		System.out.println("Data not present to be deleted");
	}

	public V search(K key) {
		int index = calculateHash(key);
		HashMapNode<K, V> object = (HashMapNode<K, V>) dataSotrage[index];
		if (object != null) {
			// first time entry
			if (object.getKey().equals(key)) {
				return object.getValue();
			} else {
				HashMapNode<K, V> headNode = object.getNext();
				while (true) {
					if (headNode == null) {
						break;
					}
					// adding item at the last
					if (headNode.getKey().equals(key)) {
						return headNode.getValue();
					}
					headNode = headNode.getNext();
				}
			}
		}
		System.out.println("Data not present");
		return null;
	}

	public int calculateHash(K key) {
		int hashCode = StringHashingUtility.asciiHashingForString(key.toString(), dataSotrage.length);
		int indexToFill = hashCode % dataSotrage.length;
		return indexToFill;
	}

	public void printBeautifully() {
		System.out.println("starting printBeautifully");
		for(Object obj:dataSotrage) {
			HashMapNode<K, V> node = (HashMapNode<K, V>) obj;
			if(node == null) {
				continue;
			}
			System.out.println("node value found with key "+node.getKey()+" and value "+node.getValue());
			HashMapNode<K, V> childNode = node.getNext();
			while(true) {
				if(childNode == null) {
					break;
				}
				System.out.println("child node found with key "+ childNode.getKey()+" and value "+childNode.getValue());
				childNode = childNode.getNext();
			}
			System.out.println("============================================");
		}
	}
}
