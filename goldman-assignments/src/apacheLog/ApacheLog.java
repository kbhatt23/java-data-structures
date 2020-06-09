package apacheLog;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ApacheLog {
	public static void main(String[] args) {
		String lines[] = new String[] { "10.0.0.1 - log entry 1 11", "10.0.0.1 - log entry 2 213",
				"10.0.0.2 - log entry 133132" };
		String result = findTopIpAddressOld(lines);

		if (result.equals("10.0.0.1")) {
			System.out.println("Test passed");

		} else {
			System.out.println("Test failed");

		}
	}

	private static String findTopIpAddressOld(String[] lines) {
		if (lines == null || lines.length == 0) {
			System.out.println("can not process empty lines");
			return null;
		}
		Map<String, Integer> ipCountMap = new HashMap<String, Integer>();
		for (String line : lines) {
			String ipWord = line.split(" ")[0];
			if (ipCountMap.containsKey(ipWord)) {
				ipCountMap.put(ipWord, ipCountMap.get(ipWord)+1);
			} else {
				ipCountMap.put(ipWord, 1);
			}
		}
		int count =0;
		String ipMax= null;
		Set<Entry<String, Integer>> entrySet = ipCountMap.entrySet();
		for(Entry<String, Integer> entry: entrySet) {
			if(count == 0) {
				ipMax = entry.getKey();
				count=entry.getValue();
			}else {
				if(entry.getValue() > count) {
					ipMax = entry.getKey();
					count = entry.getValue();
				}
			}
			
		}
		return ipMax;

	}

}
