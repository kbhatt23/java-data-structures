package selflearning.ds.dobulelinked;

public class BasicDoubleLinkedListTest4 {
public static void main(String[] args) {
	DoubleLinkedList linkedList = new DoubleLinkedList();
	linkedList.insert(1);
	linkedList.insert(2);
	linkedList.insert(3);
	linkedList.insert(9, 2);
	linkedList.printNodes();
	linkedList.deleteNode(0);
	linkedList.deleteNode(3);
	linkedList.insert(23, 0);
	linkedList.insert(99);
	linkedList.deleteNodeAtIndex(0);
	linkedList.insert(111, 0);
	linkedList.insert(999);
	System.out.println("after dleletion");
	linkedList.printNodes();
	
}
}
