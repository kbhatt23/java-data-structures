package selfllearning.ds.stack.usinglinkedlist.headonly;

public class StackUsingSingleLiinkedListTest {
public static void main(String[] args) {
	StackUsingSingleLinkedList stack = new StackUsingSingleLinkedList();
	System.out.println("size "+stack.size());
	System.out.println("stack full "+stack.isFull());
	System.out.println("has capacity available "+stack.hasCapacity());
	stack.push(1);
	stack.push(2);
	System.out.println("size "+stack.size());
	System.out.println("peek "+stack.peek());
	System.out.println("pop "+stack.pop());
	System.out.println("peek again "+stack.peek());
	System.out.println("pop again "+stack.pop());
	//expecting exception
	//System.out.println("peek again "+stack.peek());
	System.out.println("====after manipulation==========");
	System.out.println("size "+stack.size());
	System.out.println("stack full "+stack.isFull());
	System.out.println("has capacity available "+stack.hasCapacity());
	
	stack.push(99);
	stack.deleteStack();
	System.out.println("size after deletion "+ stack.size());
	System.out.println("stack full after deletion "+stack.isFull());
	System.out.println("has capacity available after deletion "+stack.hasCapacity());
	stack.push(101);
	System.out.println("peek after deltion "+stack.peek());
	System.out.println("pop after deltion "+stack.pop());
	stack.push(199);
	stack.push(201);
	System.out.println("pop after deltion "+stack.pop());
	System.out.println("pop after deltion "+stack.pop());
	
	//System.out.println("peek after deltion "+stack.peek());
}
}
