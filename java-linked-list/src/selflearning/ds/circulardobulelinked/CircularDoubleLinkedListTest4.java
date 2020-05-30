package selflearning.ds.circulardobulelinked;

public class CircularDoubleLinkedListTest4 {
	public static void main(String[] args) {
		CircularDoubleLinkedList linkedList = new CircularDoubleLinkedList();
		linkedList.insert(10);
		linkedList.insert(20);
		linkedList.insert(30);
		linkedList.insert(0, -10);
		linkedList.printNodesOnce();
		linkedList.deleteNode(20);
		linkedList.insert(99);
		System.out.println("after deleting");
		//linkedList.printNodesInfinitely();
		linkedList.printReverseNodesInfinitely();
		}
}
