package util;

public class InitializationOfInstanceVariable {
public static void main(String[] args) {
	ChildClass child = new ChildClass();
	System.out.println(child.name);
	System.out.println(child.childProperty);
}
}

class FatherClass{
	public String name = "fatherInstance";
	public FatherClass() {
		this.name="father";
	}
}

class ChildClass extends FatherClass{
	public String childProperty = "childInstance";
	public ChildClass() {
		name="child";
		childProperty = "kalingaChild";
	}
}