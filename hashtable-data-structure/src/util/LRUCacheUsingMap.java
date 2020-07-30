package util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingMap<K, V> {
	private int capacity;
	private LinkedHashMap<K, V> storage;

	public LRUCacheUsingMap(int capacity) {
		storage = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry eldest) {
				System.out.println("removing oldest entry " + eldest);
				return size() > capacity;
			}
		};
	}

	public V get(K key) {
		return storage.get(key);
	}

	public void set(K key, V value) {
		storage.put(key, value);
	}
	//print all will show items in insertion order by default
	//meaning once we sort map then we can store in linekd hashmap so that while fetching/iterating we get items in insertion order
	public void printAll() {
		storage.forEach((k,v) -> System.out.println("Fetching entry with key "+k+ " and value "+v));
	}

	public static void main(String[] args) {
		LRUCacheUsingMap<String,String> cache = new LRUCacheUsingMap<>(4);
		cache.set("first", "first");
		cache.set("second", "second");
		cache.set("third", "third");
		cache.set("fourth", "fourth");
		cache.set("five", "five");
		System.out.println(cache.get("third"));
		System.out.println(cache.get("third"));
		
		//will print items in access order 
		cache.printAll();
		
	}

}
