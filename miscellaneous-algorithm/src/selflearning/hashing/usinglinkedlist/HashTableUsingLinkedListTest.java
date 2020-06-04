package selflearning.hashing.usinglinkedlist;

public class HashTableUsingLinkedListTest {

	public static void main(String[] args) {
		HashTableUsingLinkedList hashTable = new HashTableUsingLinkedList(4);
		hashTable.insert("jai shree ram");
		hashTable.insert("jai sita ram");
		hashTable.insert("jai radha madhav");
		hashTable.insert("jai uma maheshwar");
		hashTable.insert("jai hanuman");
		hashTable.insert("jai shree ganesh");
		hashTable.insert("jai kanha");
		hashTable.insert("jai surya deva");
		hashTable.insert("jai pavan putra");
		System.out.println("=========start printing============");
		
		//hashTable.printAll();
		hashTable.delete(new String("jai kanha"));
		hashTable.insert("jai radha kanha");
		//even thoug new string creates new object
		//since hascode and equals are same it will return the data
		System.out.println("find data "+hashTable.search(new String("jai kanha")));
		
		System.out.println("find data second "+hashTable.search(new String("jai radha kanha")));
	}

}
