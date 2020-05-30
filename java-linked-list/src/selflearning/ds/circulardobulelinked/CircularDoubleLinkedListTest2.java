package selflearning.ds.circulardobulelinked;

public class CircularDoubleLinkedListTest2 {
	public static void main(String[] args) {
		CircularDoubleLinkedList linkedList = new CircularDoubleLinkedList();
		linkedList.insert(10);
		linkedList.insert(20);
		linkedList.insert(30);
		linkedList.insert(0, 40);
		System.out.println(linkedList.findNodeAtIndex(9).getValue());
		//linkedList.printNodesInfinitely();
		//linkedList.printReverseNodesInfinitely();
		
	}
}
