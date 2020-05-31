package selflearning.ds.queue.usingarrays;

import java.util.PriorityQueue;

public class JavaQueue {
	public static void main(String[] args) {

		PriorityQueue<Integer> arr = new PriorityQueue<Integer>();
		arr.add(4);
		arr.add(3);
		arr.add(2);
		arr.add(1);
		for (int i = 0; i < 4; i++) {
			System.out.println("queue at index " + i + " has value " + arr.poll());
		}
	}

}
