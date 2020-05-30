package selflearning.ds.circulardobulelinked;

public class CircularDoubleLinkedListTest {
	public static void main(String[] args) {
		CircularDoubleLinkedList linkedList = new CircularDoubleLinkedList();
		linkedList.insert(10);
		linkedList.insert(20);
		linkedList.insert(30);
		linkedList.insert(40);
		linkedList.printNodesInfinitely();
		//linkedList.printReverseNodesInfinitely();
		
	}
}
