package selflearning.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationTest {

	public static void main(String[] args) {
		SerializableClass object = new SerializableClass(108, "kanishk1", "jai shree ram");
		String filename = "file.ser";

		serializeObject(object, filename);

	}

	private static void serializeObject(SerializableClass object, String filename) {
		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(object);

			out.close();
			file.close();

			System.out.println("Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}

}
