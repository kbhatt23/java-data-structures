package selflearning.arrayoperations;


public class ArrayLastCondition {
public static void main(String[] args) {
	String[] items = {"sita", "ram"};
	StringBuilder sb = new StringBuilder();
	String seperator = ",";
	System.out.println(joinArrayItems(items, sb, seperator));
	
}

private static String joinArrayItems(String[] items, StringBuilder sb, String seperator) {
	for(int i = 0 ; i < items.length; i++) {
		String item = items[i];
		sb.append(item);
		if(i < items.length-1) {
			sb.append(seperator);
		}
	}
	return sb.toString();
}

}
