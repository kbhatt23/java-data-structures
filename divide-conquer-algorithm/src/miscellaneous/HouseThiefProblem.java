package miscellaneous;
//thief can pick only adjacent houses
//we need to max out the theft collection
public class HouseThiefProblem {
public static void main(String[] args) {
	int[] houses = new int[] {6,7,1,30,8,2,4};
	int totalCollectionMax = calculateMAxCollection(0,houses);
	System.out.println(totalCollectionMax);
}

private static int calculateMAxCollection(int index, int[] houses) {
	//base condition
	if(index >= houses.length) {
		//after last iteration we can not collect any theft
		//we did like this so that we still collect nmoney from last house
		return 0;
	}
	//pick current case
	//+2 becuase just adjacent house can not be collected
	int currentHouseTheft = houses[index]+ calculateMAxCollection(index+2, houses);
	//skip current theft
	int skipCurrentHouseTheft = calculateMAxCollection(index+1, houses);
	return Math.max(currentHouseTheft, skipCurrentHouseTheft);
}
}
