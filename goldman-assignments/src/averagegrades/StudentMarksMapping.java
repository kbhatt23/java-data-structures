package averagegrades;
class StudentMarksMapping {
	private double totalMarks;
	private int subjectCount;

	@Override
	public String toString() {
		return "StudentMarksMapping [totalMarks=" + totalMarks + ", subjectCount=" + subjectCount + "]";
	}

	public StudentMarksMapping(double totalMarks, int subjectCount) {
		super();
		this.totalMarks = totalMarks;
		this.subjectCount = subjectCount;
	}

	public double getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getSubjectCount() {
		return subjectCount;
	}

	public void setSubjectCount(int subjectCount) {
		this.subjectCount = subjectCount;
	}
}