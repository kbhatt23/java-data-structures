package selflearning.ds.circular.sibglelinkedlist;

import java.util.List;

import selflearning.ds.LinkedListNode;

public class CircularSingleLinkedListTest3 {
public static void main(String[] args) throws InterruptedException {
	CirclularSingleLinkedList linkedList = new CirclularSingleLinkedList();
	linkedList.insert(10);
	linkedList.insert(11);
	linkedList.insert(12);
	linkedList.printNodesOnce();
	//linkedList.printNodesInfinite();
	linkedList.insert(14, 2);
	System.out.println("after modification");
	linkedList.printNodesOnce();
}
}
