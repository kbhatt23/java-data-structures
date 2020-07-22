package activityselectionproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityUtils {

	public static List<Activity> fetchAllActivities() {
		Activity a1 = new Activity(1, 8, 18);
		Activity a2 = new Activity(2, 14, 18);
		Activity a3 = new Activity(3, 8, 15);
		Activity a4 = new Activity(4, 16, 18);
		Activity a5 = new Activity(5, 15, 18);
		Activity a6 = new Activity(6, 18, 20);
		return Arrays.asList(a1, a2, a3, a4, a5, a6);
	}

	// first sort by getEndtime
	// so that earliest end time is taken first and henc emaximum chance of picking
	// another possible task
	// this will allow dev to work on biggest task and need to wait/rest less ->
	// typical manager mentality
	public static List<Activity> sortActiviteisForMagic(List<Activity> activities) {
		return activities.stream().sorted(
				Comparator.comparing(Activity::getEndTime).thenComparing(Comparator.comparing(Activity::getStartTime)))
				.collect(Collectors.toList());
	}

	public static List<Activity> schedulerActivities(List<Activity> activities) {
		List<Activity> scheduledActivites = new ArrayList<Activity>();
		Activity previousActivity = null;
		for (int i = 0; i < activities.size(); i++) {
			Activity currentActivity = activities.get(i);
			if (previousActivity == null) {
				scheduledActivites.add(currentActivity);
				System.out.println("adding activity " + currentActivity);
				previousActivity = currentActivity;
			} else {
				if (previousActivity.getEndTime() <= currentActivity.getStartTime()) {
					scheduledActivites.add(currentActivity);
					System.out.println("adding activity " + currentActivity);
					previousActivity = currentActivity;
				} else {
					System.out.println("bypassing activity " + currentActivity);
				}
			}
		}
		return scheduledActivites;
	}
}
