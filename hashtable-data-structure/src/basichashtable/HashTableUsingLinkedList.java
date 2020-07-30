package basichashtable;

import util.IHashTable;

public class HashTableUsingLinkedList<K, V> implements IHashTable<K, V> {
	// lets make it growable
	private Object[] storage = new Object[3];
	private int size = 0;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void put(K key, V value) {
		// removing it as we are not considering load factor
		// if(size == storage.length) {
		// full
		// grow();
		// }
		int index = calculateHash(key);
		if (storage[index] == null) {
			// no collision
			HashTableLinkedListNode<K, V> node = new HashTableLinkedListNode<>(key, value, null);
			storage[index] = node;
		} else {
			// collision case
			HashTableLinkedListNode<K, V> currentNode = (HashTableLinkedListNode<K, V>) storage[index];
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(new HashTableLinkedListNode<>(key, value, null));
		}
		size++;
	}

	// not tryin to add with load factory like 0.75 and all
	private void grow() {
		System.out.println("growing exising array");
		// lets move to 10 later on
		Object[] newArray = new Object[storage.length + 2];
		for (int i = 0; i < storage.length; i++) {
			newArray[i] = storage[i];
		}
		storage = newArray;
	}

	@Override
	public V get(K key) {
		int index = calculateHash(key);
		if (storage[index] == null) {
			System.out.println("Item not found with key " + key);
		} else {
			// collision case
			HashTableLinkedListNode<K, V> currentNode = (HashTableLinkedListNode<K, V>) storage[index];
			if (currentNode.getKey().equals(key)) {
				return currentNode.getValue();
			} else {
				while (currentNode!= null) {
					if (currentNode.getKey().equals(key)) {
						return currentNode.getValue();
					}
					currentNode = currentNode.getNext();
				}
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		int index = calculateHash(key);
		if (storage[index] == null) {
			System.out.println("Item not found with key " + key);
		} else {
			// collision case
			HashTableLinkedListNode<K, V> currentNode = (HashTableLinkedListNode<K, V>) storage[index];
			if (currentNode.getKey().equals(key)) {
				storage[index] = currentNode.getNext();
				size--;
				return currentNode.getValue();
			} else {
				HashTableLinkedListNode<K, V> previousNode = currentNode;
				currentNode = previousNode.getNext();
				while (currentNode != null) {
					if (currentNode.getKey().equals(key)) {
						V value = currentNode.getValue();
						previousNode.setNext(currentNode.getNext());
						size--;
						return value;
					}
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
			}
		}
		return null;

	}

	private int calculateHash(K key) {
		int hashCode = key.hashCode();
		int indexToFill = hashCode % storage.length;
		return indexToFill;
	}

}
