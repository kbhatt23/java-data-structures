package selflearning.ds.dobulelinked;

public class BasicDoubleLinkedListTest6 {
public static void main(String[] args) {
	DoubleLinkedList linkedList = new DoubleLinkedList();
	linkedList.insert(1);
	linkedList.insert(2);
	linkedList.insert(3);
	linkedList.printNodes();
	LinkedListNodeDouble searchNode = linkedList.searchNode(3);
	System.out.println("item found "+searchNode);
	if(searchNode!= null) {
		System.out.println(searchNode.getValue());
	}
}
}
