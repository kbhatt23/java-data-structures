package basics;

public class RecursiveBasicTemplate {
	public static void main(String[] args) {
		RecursiveBasicTemplate obj = new RecursiveBasicTemplate();
		obj.recuriveMethod(5);
		System.out.println("all task completed");
	}

//similar to for loop with i-- condition
	private void recuriveMethod(int i) {
		System.out.println("processing number "+i);
		if (i < 1) {
			return;
		}
		recuriveMethod(i - 1);
		System.out.println("done processing number "+i);
	}
}
