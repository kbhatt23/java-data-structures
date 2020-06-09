package robotmovement;

public class RobotMovementTest {

	public static void main(String[] args) {
		Robot robot = new Robot();
		System.out.println("initial robot position " + robot);
		
		walkRobot("RRRDUUULLR", robot);
		System.out.println("final robot position " + robot);

	}

	private static void walkRobot(String steps, Robot robot) {
		if (!Robot.validateSteps(steps)) {
			throw new RuntimeException("please provide valid steps");
		}
		for (char step : steps.toCharArray()) {
			switch (step) {
			case 'U':
				robot.setY(1+robot.getY());
				break;
			case 'D':
				robot.setY(robot.getY()-1);
				break;
			case 'R':
				robot.setX(1+robot.getX());
				break;
			case 'L':
				robot.setX(robot.getX()-1);
				break;	

			default:
				break;
			}
		}
	}

}
