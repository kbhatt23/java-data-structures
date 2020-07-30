package util;

import java.util.HashMap;
import java.util.Map;

public class HAshMapPutAll {

	public static void main(String[] args) {
		Map<String, String> sourceMap = new HashMap<String, String>();
		sourceMap.put("name", "kanha");
		sourceMap.put("age", "23");
		sourceMap.put("hobby", "football");
		sourceMap.put("club", "barcelona");
		
		Map<String, String> childMap = new HashMap<String, String>();
		childMap.put("name", "krishna");
		childMap.put("love", "radha");
		childMap.put("village", "gokul");
		sourceMap.putAll(childMap);
		
		System.out.println("child "+childMap);
		System.out.println("source "+sourceMap);
	}

}
