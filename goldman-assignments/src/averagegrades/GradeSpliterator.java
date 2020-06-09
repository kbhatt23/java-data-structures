package averagegrades;

import java.util.HashMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

public class GradeSpliterator implements Spliterator<Map<String, StudentMarksMapping>> {

	private Map<String, StudentMarksMapping> resultMap = new HashMap<>();

	private Spliterator<String[][]> baseSpliterator;
	public GradeSpliterator(Spliterator<String[][]> baseSpliterator) {
		this.baseSpliterator = baseSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Map<String, StudentMarksMapping>> action) {
		Consumer<String[][]> dataMapConsumer = (array) -> {
			Map<String, StudentMarksMapping> totalMArksByStudentName = new HashMap<>();
			for (String[] marksItem : array) {
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
			resultMap = totalMArksByStudentName;
		};
		
		if(baseSpliterator.tryAdvance(dataMapConsumer)) {
			action.accept(resultMap);
			return true;
		}
		return false;
	}

	@Override
	public Spliterator<Map<String, StudentMarksMapping>> trySplit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long estimateSize() {
		return baseSpliterator.estimateSize();
	}

	@Override
	public int characteristics() {
		return baseSpliterator.characteristics();
	}

}
