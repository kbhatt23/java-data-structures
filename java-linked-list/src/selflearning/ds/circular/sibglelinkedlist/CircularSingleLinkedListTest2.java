package selflearning.ds.circular.sibglelinkedlist;

import java.util.List;

import selflearning.ds.LinkedListNode;

public class CircularSingleLinkedListTest2 {
public static void main(String[] args) throws InterruptedException {
	CirclularSingleLinkedList linkedList = new CirclularSingleLinkedList();
	linkedList.insert(10);
	linkedList.insert(11);
	linkedList.insert(12);
	linkedList.printNodesOnce();
	List<LinkedListNode> findPReviousAndCurrent = linkedList.findPReviousAndCurrent(6);
	System.out.println("node found previous "+findPReviousAndCurrent.get(0).getValue());
	System.out.println("node found current "+findPReviousAndCurrent.get(1).getValue());
	//linkedList.printNodesInfinite();
}
}
