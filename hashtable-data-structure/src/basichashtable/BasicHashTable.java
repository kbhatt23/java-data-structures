package basichashtable;

import util.IHashTable;

//this class do not allow collsion as hashing method is weak
//also no hanlding on D.S level
//as of now assuming key as string to create bad hashing method
public class BasicHashTable<V> implements IHashTable<String, V>{

	private Object[] storage = new Object[5];

	@Override
	public int size() {
		int size = 0;
		for(int i = 0 ; i <storage.length ; i++) {
			if(storage[i] != null) {
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
		int keyHash = hashKey(key);
		if(storage[keyHash] != null) {
			System.out.println("Data laready present at index "+keyHash+" hence ignoring insertion for "+value);
		}else {
			storage[keyHash] = value;
		}
	}

	@Override
	public V get(String key) {
		int keyHash = hashKey(key);
		return (V) storage[keyHash];
	}
	private int hashKey(String key) {
		return key.length() % storage.length;
	}

	@Override
	public V remove(String key) {

		int keyHash = hashKey(key);
		V value = (V) storage[keyHash];
		storage[keyHash] = null;
		return value;
	}

}
