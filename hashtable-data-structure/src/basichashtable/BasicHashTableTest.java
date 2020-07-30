package basichashtable;

import util.Employee;

public class BasicHashTableTest {

	public static void main(String[] args) {
		BasicHashTable<Employee> ht = new BasicHashTable<Employee>();
		Employee e1 = new Employee(1, "ganesh", 101);
		Employee e2 = new Employee(2, "mahesh", 999);
		Employee e3 = new Employee(3, "suresh", 108);
		Employee e4 = new Employee(4, "damodar", 11);
		Employee e5 = new Employee(5, "radha", 111);
		ht.put("ganesh", e1);
		ht.put("damodar", e2);
		ht.put("suresh", e3);
		//trying to seach for constant time
		System.out.println(ht.get("ganesh"));
		System.out.println(ht.get("damodar"));
		//had it been a node[] implemention we coudl have check if key.equals -> key from the node index found
		System.out.println(ht.get("suresh"));
		System.out.println("lets remove");
		//ht.remove("damodar");
		System.out.println(ht.get("damodar"));
	}

}
