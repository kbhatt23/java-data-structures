package robotmovement;
//assuming 2d robot
//x axis and y axis are movment planes

import java.util.HashSet;
import java.util.Set;

public class Robot {
	private static final Set<Character> validMovementSteps ;
	static {
		validMovementSteps = new HashSet<Character>();
		validMovementSteps.add('U');
		validMovementSteps.add('D');
		validMovementSteps.add('L');
		validMovementSteps.add('R');
	}
	public static boolean validateSteps(String steps) {
		boolean isValid = true;
		for(char step : steps.toCharArray()) {
			if(!validMovementSteps.contains(step)) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	private int x;
	
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Robot [x=" + x + ", y=" + y + "]";
	}
}
