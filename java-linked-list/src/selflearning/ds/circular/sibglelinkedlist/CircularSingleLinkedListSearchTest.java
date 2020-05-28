package selflearning.ds.circular.sibglelinkedlist;

import selflearning.ds.LinkedListNode;

public class CircularSingleLinkedListSearchTest {
public static void main(String[] args) throws InterruptedException {
	CirclularSingleLinkedList linkedList = new CirclularSingleLinkedList();
	linkedList.insert(10);
	linkedList.insert(11);
	linkedList.insert(12);
	linkedList.deleteNode(12);
	System.out.println("inital data nodes")
	;
	linkedList.printNodesOnce();
	LinkedListNode searchNode = linkedList.searchNode(10);
	if(searchNode != null)
	System.out.println(searchNode.getValue());
}
}
