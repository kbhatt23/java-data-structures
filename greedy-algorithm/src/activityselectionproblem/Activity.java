package activityselectionproblem;

public class Activity {
	private int id;
	private int startTime;
	private int endTime;

	@Override
	public String toString() {
		return "Activity [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public Activity(int id, int startTime, int endTime) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
