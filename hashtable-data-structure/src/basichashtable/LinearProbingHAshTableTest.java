package basichashtable;

import util.Employee;

public class LinearProbingHAshTableTest {

	public static void main(String[] args) {
		HashTableWithLinearProbing<Employee> ht = new HashTableWithLinearProbing<Employee>();
		Employee e1 = new Employee(1, "ganesh", 101);
		Employee e2 = new Employee(2, "mahesh", 999);
		Employee e3 = new Employee(3, "suresh", 108);
		Employee e4 = new Employee(4, "damodar", 11);
		Employee e5 = new Employee(5, "radha", 111);
		ht.put("ganesh", e1);
		ht.put("mahesh", e2);
		ht.put("suresh", e3);
		ht.put("damodar", e4);
		ht.put("radha", e5);
		//trying to seach for constant time
		System.out.println(ht.get("ganesh"));
		System.out.println(ht.get("damodar"));
		//had it been a node[] implemention we coudl have check if key.equals -> key from the node index found
		System.out.println(ht.get("radha"));
		System.out.println("lets start removing");
		System.out.println(ht.remove("mahesh"));
		System.out.println(ht.get("suresh"));
		System.out.println(ht.size());
	}

}
