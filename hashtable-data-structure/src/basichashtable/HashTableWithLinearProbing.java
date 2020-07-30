package basichashtable;

import util.IHashTable;

public class HashTableWithLinearProbing<V> implements IHashTable<String, V> {
	private Object[] storage = new Object[5];

	@Override
	public int size() {
		int size = 0;
		for (int i = 0; i < storage.length; i++) {
			if (isOccupiedIndex(i)) {
				size++;
			}
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void put(String key, V value) {
		int index = generateHAshIndex(key);
		LinearProbingNode<String, V> nodeValue = new LinearProbingNode<>(key, value);
		if (isOccupiedIndex(index)) {
			boolean isSaved = false;
			for (int i = index + 1; i < storage.length; i++) {
				if (!isOccupiedIndex(i)) {
					storage[i] = nodeValue;
					isSaved = true;
					break;
				}
			}
			if (!isSaved) {
				for (int i = 0; i < index; i++) {
					if (!isOccupiedIndex(i)) {
						storage[i] = nodeValue;
						isSaved = true;
						break;
					}
				}
			}
			if (!isSaved) {
				System.out.println("sorry unable to put value " + value + " using key " + key);
			}
		} else {
			storage[index] = nodeValue;
		}
	}

	@Override
	public V get(String key) {
		int index = generateHAshIndex(key);
		LinearProbingNode<String, V> nodeValue = (LinearProbingNode<String, V>) storage[index];
		if (nodeValue == null) {
			System.out.println("item not found with key " + key);
			return null;
		}
		if (nodeValue.getKey().equals(key)) {
			return nodeValue.getValue();
		} else {
			for (int i = index + 1; i < storage.length; i++) {
				if (isOccupiedIndex(i)) {
					LinearProbingNode<String, V> foundNode = (LinearProbingNode<String, V>) storage[i];
					if (foundNode.getKey().equals(key)) {
						return foundNode.getValue();
					}
				}
				//below else condition looks good but it can cause bu
				//example o 1 and 2 indices have same hashcode generated and we remove item at index 0 then it will make index2 to be not found
				// as 0 and 2 have same hashcode we start from 0 and since 1 is null we break the loop
				//hence lets remove this else case
				else {
					//in this case we know that item is not present
					//as in ae of collision we always put item to next and in case next is occupied we go to next of the next
					// so in case index is occupied and index+1 is null it means no need to iterate
					break;
				}
			}
			for (int i = 0; i < index; i++) {
				if (isOccupiedIndex(i)) {
					LinearProbingNode<String, V> foundNode = (LinearProbingNode<String, V>) storage[i];
					if (foundNode.getKey().equals(key)) {
						return foundNode.getValue();
					}
				}
			}
			System.out.println("sorry unable to find value using key " + key);
			return null;
		}

	}

	private int generateHAshIndex(String key) {
		return key.length() % storage.length;
	}

	private boolean isOccupiedIndex(int index) {
		return storage[index] != null;
	}

	@Override
	public V remove(String key) {
		int index = generateHAshIndex(key);
		LinearProbingNode<String, V> nodeValue = (LinearProbingNode<String, V>) storage[index];
		if (nodeValue == null) {
			System.out.println("item not found with key " + key);
			return null;
		}
		if (nodeValue.getKey().equals(key)) {
			storage[index] = null;
			return nodeValue.getValue();
		} else {
			for (int i = index + 1; i < storage.length; i++) {
				if (isOccupiedIndex(i)) {
					LinearProbingNode<String, V> foundNode = (LinearProbingNode<String, V>) storage[i];
					if (foundNode.getKey().equals(key)) {
						storage[i] = null;
						return foundNode.getValue();
					}
				}
			}
			for (int i = 0; i < index; i++) {
				if (isOccupiedIndex(i)) {
					LinearProbingNode<String, V> foundNode = (LinearProbingNode<String, V>) storage[i];
					if (foundNode.getKey().equals(key)) {
						storage[i] = null;
						return foundNode.getValue();
					}
				}
			}
			System.out.println("sorry unable to find value using key " + key);
			return null;
		}

	
	}

}
