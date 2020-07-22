package activityselectionproblem;

import java.util.List;

public class ActivityScheduler {
	public static void main(String[] args) {
		List<Activity> sortActiviteisForMagic = ActivityUtils
				.sortActiviteisForMagic(ActivityUtils.fetchAllActivities());
		System.out.println("final scheduled activities " + ActivityUtils.schedulerActivities(sortActiviteisForMagic));

	}
}
