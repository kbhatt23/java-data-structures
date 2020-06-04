package selflearning.hashing.usinglinkedlist;

import selflearning.hashing.utility.StringHashingUtility;

public class HashTableUsingLinkedList {
	private  HashTableNode[] dataSotrage;
	//no need to increase size as linmked list can be used in case of collision
	public HashTableUsingLinkedList(int size) {
		dataSotrage = new  HashTableNode[size];
	}
	
	public void insert(String data) {
		int index = calculateHash(data);
		if(dataSotrage[index] == null) {
			//first time entry
			System.out.println("index have no collision at index "+index + " with value "+data);
			dataSotrage[index] = new HashTableNode(data, null);
		}else {
			HashTableNode headNode = dataSotrage[index];
			
			while(true) {
				//adding item at the last
				if(headNode.getNext() == null) {
					System.out.println("collision is there for index "+index+ " with value "+data+" creating node after "+headNode.getValue());
					headNode.setNext(new HashTableNode(data, null));
					return;
				}
				headNode = headNode.getNext();
			}
		}
	}
	
	public void delete(String data) {
		int index = calculateHash(data);
		if(dataSotrage[index] != null ) {
			//first time entry
			if(dataSotrage[index].getValue().equals(data)) {
				dataSotrage[index] = null;
			}
		else {
			HashTableNode headNode = dataSotrage[index].getNext();
			HashTableNode previousNode = dataSotrage[index];
			while(true) {
				if(headNode == null) {
					break;
				}
				//adding item at the last
				if(headNode.getValue().equals(data)) {
					previousNode.setNext(null);
					return;
				}
				previousNode = headNode;
				headNode = headNode.getNext();
			}
		}
		System.out.println("Data not present to be deleted");	
		}
	}
	
	public String search(String data) {
		int index = calculateHash(data);
		if(dataSotrage[index] != null ) {
			//first time entry
			if(dataSotrage[index].getValue().equals(data)) {
				return dataSotrage[index].getValue();
			}
		else {
			HashTableNode headNode = dataSotrage[index].getNext();
			while(true) {
				if(headNode == null) {
					break;
				}
				//adding item at the last
				if(headNode.getValue().equals(data)) {
					return headNode.getValue();
				}
				headNode = headNode.getNext();
			}
		}
		}
		System.out.println("Data not present");
		return null;
	}
	
	public int calculateHash(String data) {
		int hashCode = StringHashingUtility.asciiHashingForString(data, dataSotrage.length);
		int indexToFill = hashCode % dataSotrage.length;
		return indexToFill;
	}
	
	public void printAll() {
		
	}
}
