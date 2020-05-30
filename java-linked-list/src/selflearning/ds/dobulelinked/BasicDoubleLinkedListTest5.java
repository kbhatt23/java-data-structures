package selflearning.ds.dobulelinked;

public class BasicDoubleLinkedListTest5 {
public static void main(String[] args) {
	DoubleLinkedList linkedList = new DoubleLinkedList();
	linkedList.insert(1);
	linkedList.insert(2);
	linkedList.insert(3);
	linkedList.printReverse();
	System.out.println("once again");
	linkedList.printReverseUsingLoop();
}
}
