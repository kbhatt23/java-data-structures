package selflearning.ds.dobulelinked;

public class BasicDoubleLinkedListTest7 {
	public static void main(String[] args) {
		DoubleLinkedList linkedList = new DoubleLinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.printNodesUsingLoop();
		linkedList.removeLinkedList();
		// testing if deletion was susccess
		linkedList.printNodesUsingLoop();
	}
}
