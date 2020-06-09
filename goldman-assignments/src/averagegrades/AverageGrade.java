package averagegrades;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class AverageGrade {

	public static void main(String[] args) {

		String[][] marksData = { { "kanishk", "86" }, { "raghav", "100" }, { "kanishk", "94" }, { "raghav", "78" },
				{ "charles", "56" }, { "megha", "77" }, { "megha", "99" }, { "charles", "87" } };

		averageMarksByStudentNameV1(marksData).entrySet().forEach(System.out::println);
		System.out.println("java 8 way");
		averageMarksByStudentNameV2(marksData).entrySet().forEach(System.out::println);
	}

	// using java7
	private static Map<String, Double> averageMarksByStudentNameV1(String[][] marksData) {
		Map<String, StudentMarksMapping> totalMArksByStudentName = new HashMap<>();
		populateTotalMArksDataMap(marksData, totalMArksByStudentName);
		Map<String, Double> averageMarksMap = new HashMap<>();
		Set<Entry<String, StudentMarksMapping>> entrySet = totalMArksByStudentName.entrySet();
		for (Entry<String, StudentMarksMapping> totalMarksEntry : entrySet) {
			double average = Double.valueOf(totalMarksEntry.getValue().getTotalMarks())
					/ totalMarksEntry.getValue().getSubjectCount();
			averageMarksMap.put(totalMarksEntry.getKey(), average);
		}

		return averageMarksMap;

	}

	private static void populateTotalMArksDataMap(String[][] marksData,
			Map<String, StudentMarksMapping> totalMArksByStudentName) {
		for (String[] marksItem : marksData) {
			String studentName = marksItem[0];
			String marks = marksItem[1];
			if (totalMArksByStudentName.containsKey(studentName)) {
				StudentMarksMapping currentStudentData = totalMArksByStudentName.get(studentName);
				currentStudentData.setSubjectCount(1 + currentStudentData.getSubjectCount());
				currentStudentData.setTotalMarks(currentStudentData.getTotalMarks() + Double.valueOf(marks));
			} else {
				StudentMarksMapping studentData = new StudentMarksMapping(Double.valueOf(marks), 1);
				totalMArksByStudentName.put(studentName, studentData);
			}
		}
	}

	// using java8
	private static Map<String, Double> averageMarksByStudentNameV2(String[][] marksData) {
		Map<String, StudentMarksMapping> totalMArksByStudentName = new HashMap<>();
		populateTotalMArksDataMap(marksData, totalMArksByStudentName);
		return totalMArksByStudentName.entrySet().stream().collect(Collectors.toMap(Entry::getKey, e -> {
			Entry<String, StudentMarksMapping> entryReal = (Entry<String, StudentMarksMapping>) e;
			return entryReal.getValue().getTotalMarks() / entryReal.getValue().getSubjectCount();
		}));

	}

}
