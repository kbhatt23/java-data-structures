package selflearning.serialization;

import java.io.Serializable;

public class SerializableClass implements Serializable{

	private static final long serialVersionUID = -698424596977783171L;

	private int index;
	private String name;
	private String value;
	public SerializableClass(int index, String name, String value) {
		this.index = index;
		this.name = name;
		this.value = value;
	}
	@Override
	public String toString() {
		return "SerializableClass [index=" + index + ", name=" + name + ", value=" + value + "]";
	}
}
