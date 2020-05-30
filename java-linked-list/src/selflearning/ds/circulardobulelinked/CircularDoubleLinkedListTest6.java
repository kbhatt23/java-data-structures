package selflearning.ds.circulardobulelinked;

import selflearning.ds.dobulelinked.LinkedListNodeDouble;

public class CircularDoubleLinkedListTest6 {
	public static void main(String[] args) {
		CircularDoubleLinkedList linkedList = new CircularDoubleLinkedList();
		linkedList.insert(10);
		linkedList.insert(20);
		linkedList.insert(30);
		linkedList.insert(0, -10);
		linkedList.printNodesOnce();
		LinkedListNodeDouble findNode = linkedList.findNode(-99);
		System.out.println("node found "+findNode);
		if(findNode != null)System.out.println("value found "+findNode.getValue());
	}
}
