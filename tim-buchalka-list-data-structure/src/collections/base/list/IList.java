package collections.base.list;

public interface IList<T> {
	void add(T t);
	void add(int index, T t);
	T get(int index);
	boolean isEmpty();
	void set(int index, T t);
	int size();
	boolean contains(T t);
	int indexOf(T t);
	void remove(int index);
	void remove(T t);
}
