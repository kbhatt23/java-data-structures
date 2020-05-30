package selflearning.ds.circulardobulelinked;

public class CircularDoubleLinkedListTest3 {
	public static void main(String[] args) {
		CircularDoubleLinkedList linkedList = new CircularDoubleLinkedList();
		linkedList.insert(10);
		linkedList.insert(20);
		linkedList.insert(30);
		linkedList.insert(3, 40);
		//linkedList.printNodesInfinitely();
		linkedList.printReverseNodesInfinitely();
		
	}
}
