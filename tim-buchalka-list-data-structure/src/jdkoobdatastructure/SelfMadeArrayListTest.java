package jdkoobdatastructure;

import collections.base.list.IList;
import util.Employee;

public class SelfMadeArrayListTest {
public static void main(String[] args) {
	IList<Employee> arrayList =new SelfMadeArrayList<Employee>(2);
	arrayList.add(new Employee(1, "ganesh", 1008));
	arrayList.add(new Employee(2, "krishna", 1009));
	arrayList.add(new Employee(3, "mahesh", 1010));
	
	//arrayList.add(4, new Employee(4, "keshav", 999));
	arrayList.add(3, new Employee(4, "keshav", 999));
	System.out.println(arrayList.contains(new Employee(2, "krishna", 1009)));
	System.out.println(arrayList.size());
	System.out.println(arrayList.get(3));
	System.out.println("iteration se pehle");
	for(int i =0 ; i < arrayList.size() ; i++) {
		System.out.println(arrayList.get(i));
	}
	System.out.println("oteration ke baad");
	arrayList.add(1 , new Employee(5, "radha", 998));
	for(int i =0 ; i < arrayList.size() ; i++) {
		System.out.println(arrayList.get(i));
	}
	
	//removing test:
	
	arrayList.remove(5);
	System.out.println("printing items after removal");
	for(int i =0 ; i < arrayList.size() ; i++) {
		System.out.println(arrayList.get(i));
	}
}
}
