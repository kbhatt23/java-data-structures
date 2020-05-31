package selflearning.ds.queue.usingLinkedlist;

public class QueueUsingLinkedListTest1 {
public static void main(String[] args) {
	QueueUsingLinkedList queue = new QueueUsingLinkedList();
	queue.enQueue(10);
	System.out.println("initail size "+queue.size());
	System.out.println("initail capacity "+queue.hasCapacity());
	System.out.println("initail isempty "+queue.isEmpty());
	System.out.println("initail isfull "+queue.isFull());
	System.out.println("peek first "+queue.peekQueue());
	System.out.println("deque first "+queue.deQueue());
	
	queue.enQueue(100);
	queue.enQueue(200);
	System.out.println("new queue  size "+queue.size());
	System.out.println("peek after maipulation once "+queue.peekQueue());
	System.out.println("peek after maipulation twice "+queue.peekQueue());
	System.out.println("dequeue after maipulation twice "+queue.deQueue());
	System.out.println("dequeue after maipulation thrice "+queue.deQueue());
	
}
}
