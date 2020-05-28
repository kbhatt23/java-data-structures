package selflearning.ds.circular.sibglelinkedlist;

public class CircularSingleLinkedListDeleteTest {
public static void main(String[] args) throws InterruptedException {
	CirclularSingleLinkedList linkedList = new CirclularSingleLinkedList();
	linkedList.insert(10);
	linkedList.insert(11);
	linkedList.insert(12);
	linkedList.printNodesOnce();
	//linkedList.printNodesInfinite();
}
}
