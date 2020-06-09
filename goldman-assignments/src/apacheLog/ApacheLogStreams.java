package apacheLog;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApacheLogStreams {
	public static void main(String[] args) {
		String lines[] = new String[] { "10.0.0.1 - log entry 1 11", "10.0.0.1 - log entry 2 213",
				"10.0.0.2 - log entry 133132" };
		String result = findTopIpAddressOld(lines);

		if (result.equals("10.0.0.1")) {
			System.out.println("Test passed");

		} else {
			System.out.println("Test failed");

		}
		
		String result1 = findTopIpAddressNew(lines);

		if (result1.equals("10.0.0.1")) {
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
		Map<String, Long> ipCountMap = Arrays.stream(lines).map(str -> str.split(" ")[0])
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		long maxCount = ipCountMap.entrySet().stream().mapToLong(Entry::getValue).max()
				.orElseThrow(RuntimeException::new);

		return ipCountMap.entrySet().stream().filter(entry -> maxCount == entry.getValue()).findFirst().get().getKey();

	}

	private static String findTopIpAddressNew(String[] lines) {
		if (lines == null || lines.length == 0) {
			System.out.println("can not process empty lines");
			return null;
		}
		Map<String, Long> ipCountMap = Arrays.stream(lines).map(str -> str.split(" ")[0])
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		LinkedHashMap<String, Long> orderedMap = ipCountMap.entrySet().stream()
				.sorted(Entry.<String, Long>comparingByValue().reversed())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))

		;

		return orderedMap.entrySet().stream().findFirst().get().getKey();
	}

}
