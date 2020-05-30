package selflearning.ds.dobulelinked;

public class BasicDoubleLinkedListTest2 {
public static void main(String[] args) {
	DoubleLinkedList linkedList = new DoubleLinkedList();
	linkedList.insert(1);
	linkedList.insert(2);
	linkedList.insert(3);
	linkedList.insert(9, 2);
	linkedList.printNodes();
	LinkedListNodeDouble findNodeAtIndex = linkedList.findNodeAtIndex(3);
	if(findNodeAtIndex!=null) {
		System.out.println("searched item "+findNodeAtIndex.getValue());
	}else {
		System.out.println("null item found in searching");
	}
	
}
}
