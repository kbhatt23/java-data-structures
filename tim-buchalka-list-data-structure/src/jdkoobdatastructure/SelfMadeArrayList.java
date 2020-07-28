package jdkoobdatastructure;

import collections.base.list.IList;

public class SelfMadeArrayList<T> implements IList<T>{

	private Object[] storage;
	int arrayIndex =0;

	public SelfMadeArrayList() {
		//initial capacity
		storage = new Object[10];
	}
	public SelfMadeArrayList(int initialCapacity) {
		storage = new Object[initialCapacity];
	}
	@Override
	public void add(T t) {
		//always insert at the end
		if(arrayIndex == storage.length) {
			grow();
		}
		storage[arrayIndex] = t;
		arrayIndex++;
	}
	//not tryin to add with load factory like 0.75 and all
	private void grow() {
		System.out.println("growing exising array");
		//lets move to 10 later on
		Object[] newArray = new Object[storage.length+5];
		for(int i=0 ; i< storage.length ; i++) {
			newArray[i] = storage[i];
		}
		storage = newArray;
	}
	@Override
	public void add(int index, T t) {
		//insertion and not direct overriding
		if(index > size()) {
			throw new RuntimeException("Array index out of bound for index "+index +" size available "+size());
		}
		if(index == size()) {
			add(t);
		}else {
			if(arrayIndex == storage.length) {
				//array already full
				grow();
			}
			T existingValue = (T)storage[index];
			storage[index] = t;
			shiftArrayCellstoRight(existingValue, index);
			arrayIndex++;
		}
	}
	private  void shiftArrayCellstoRight(T value , int index) {
		for(int i= index+1; i < storage.length; i++ ) {
			T existingValue = (T) storage[i];
			storage[i] = value;
			value = existingValue;
		}
	}
	@Override
	public T get(int index) {
		if(index > size()) {
			throw new RuntimeException("Array index out of bound for index "+index +" size available "+size());
		}
		return (T)storage[index];
	}
	@Override
	public boolean isEmpty() {
		return arrayIndex == 0;
	}
	@Override
	public void set(int index, T t) {
		if(index > size()) {
			throw new RuntimeException("Array index out of bound for index "+index +" size available "+size());
		}
		storage[index] = t;
	}
	@Override
	public int size() {
		return arrayIndex;
	}
	@Override
	public boolean contains(T t) {
		boolean contains = false;
		for(Object item : storage) {
			T itemTyped = (T)item;
			if(itemTyped.equals(t)) {
				contains=true;
				break;
			}
		}
		return contains;
	}
	@Override
	public int indexOf(T t) {
		int index =-1;
		int i=0;
		for(Object item : storage) {
			T itemTyped = (T)item;
			if(itemTyped.equals(t)) {
				index = i;
				break;
			}
			i++;
		}
		if(index == -1) {
			throw new RuntimeException("Item "+t+" not found");
		}
		return index;
	}
	@Override
	public void remove(int index) {
		if(index > size() || index <0) {
			throw new RuntimeException("Array index out of bound for index "+index +" size available "+size());
		}
		shiftCellsToLeft(index);
		arrayIndex--;
	}
	private void shiftCellsToLeft(int index) {
		for(int i = index ; i < storage.length-1 ; i++) {
			storage[i] = storage[i+1];
		}
	}
	@Override
	public void remove(T t) {
		//lets do it tommorrow
		
		
	}
	
}
