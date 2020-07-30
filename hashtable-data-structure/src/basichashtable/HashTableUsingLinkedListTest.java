package basichashtable;

import util.Employee;

public class HashTableUsingLinkedListTest {

	public static void main(String[] args) {
		HashTableUsingLinkedList<String, Employee> ht = new HashTableUsingLinkedList<String, Employee>();
		Employee e1 = new Employee(1, "ganesh", 101);
		Employee e2 = new Employee(2, "mahesh", 999);
		Employee e3 = new Employee(3, "suresh", 108);
		Employee e4 = new Employee(4, "damodar", 11);
		Employee e5 = new Employee(5, "radha", 111);
		ht.put("AaAa", e1);
		ht.put("BBBB", e2);
		ht.put("AaBB", e3);
		System.out.println(ht.get("AaAa"));
		System.out.println(ht.get("BBBB"));
		System.out.println(ht.get("AaBB"));
		System.out.println("lets remove");
		System.out.println(ht.remove("BBBB"));
		System.out.println(ht.get("AaAa"));
		System.out.println(ht.get("BBBB"));
		System.out.println(ht.get("AaBB"));
		System.out.println(ht.size());
		
	}

}
