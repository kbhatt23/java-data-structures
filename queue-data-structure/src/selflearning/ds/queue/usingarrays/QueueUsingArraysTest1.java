package selflearning.ds.queue.usingarrays;

public class QueueUsingArraysTest1{
	public static void main(String[] args) {
		QueueUsingArrays queue = new QueueUsingArrays(1);
		queue.enQueue(1);
		System.out.println("size "+queue.size());
		System.out.println("has capacity "+queue.hasCapacity());
		System.out.println("isfull "+queue.isFull());
		System.out.println("isEmpty "+queue.isEmpty());
		System.out.println("peek once "+queue.peekQueue());
		System.out.println("pop once "+queue.deQueue());
		//System.out.println("peek once again"+queue.peekQueue());
		queue.deQueue();
		System.out.println("peek last "+queue.peekQueue());
		System.out.println("pop last "+queue.deQueue());
		
	}
}
