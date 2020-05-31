package selflearning.ds.queue.usingarrays;

public class QueueUsingArraysTest3{
	public static void main(String[] args) {
		QueueUsingArrays queue = new QueueUsingArrays(3);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		System.out.println("size "+queue.size());
		System.out.println("has capacity "+queue.hasCapacity());
		System.out.println("isfull "+queue.isFull());
		System.out.println("isEmpty "+queue.isEmpty());
		System.out.println("peek once "+queue.peekQueue());
		System.out.println("pop once "+queue.deQueue());
		System.out.println("isEmpty after popping "+queue.isEmpty());
		System.out.println("peek once again "+queue.peekQueue());
		System.out.println("pop once again"+queue.deQueue());
		System.out.println("peek last time  "+queue.peekQueue());
		
	}
}
