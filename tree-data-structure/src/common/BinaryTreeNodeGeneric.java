package common;

public class BinaryTreeNodeGeneric<T> {
	
	private T value;
	private BinaryTreeNodeGeneric<T> left;
	private BinaryTreeNodeGeneric<T> right;
	public BinaryTreeNodeGeneric(T value, BinaryTreeNodeGeneric<T> left, BinaryTreeNodeGeneric<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public BinaryTreeNodeGeneric<T> getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNodeGeneric<T> left) {
		this.left = left;
	}
	public BinaryTreeNodeGeneric<T> getRight() {
		return right;
	}
	public void setRight(BinaryTreeNodeGeneric<T> right) {
		this.right = right;
	}
	
}
