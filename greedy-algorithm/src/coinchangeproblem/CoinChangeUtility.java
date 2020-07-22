package coinchangeproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChangeUtility {

	public static int[] fetchAllCoins() {
		return new int[] { 1, 2, 5, 20, 50, 100, 500, 1000 };
	}

	// do not work
	public static int findMinCoinToAddRuppeeSelFLearnt(int[] coins, int ruppees) {
		// -1 means not found at all
		int minCountfound = -1;
		for (int i = 0; i < coins.length; i++) {
			List<Integer> coinItems = new ArrayList<Integer>();
			boolean isCountFound = false;
			int sum = coins[i];
			coinItems.add(sum);
			for (int j = i + 1; j < coins.length; j++) {
				// chcek if itself is enough
				if (sum == ruppees) {
					isCountFound = true;
					break;
				}
				int next = coins[j];
				sum = sum + next;
				coinItems.add(next);
				if (sum == ruppees) {
					isCountFound = true;
					break;
				}
			}
			if (isCountFound && (minCountfound == -1 || minCountfound > coinItems.size())) {
				minCountfound = coinItems.size();
			}
		}

		return minCountfound;
	}

	public static Map<Integer, Integer> findMinCoinToAddRuppeeAlgo(int[] coins, int ruppees) {
		// sorting is type fo greed
		// as we are forcing the same itme of array not to be traversed again
		sortBasic(coins);
		Map<Integer, Integer> coinMap = new HashMap<Integer, Integer>();
		for (int i = coins.length - 1; i >= 0; i--) {
			int currentCoin = coins[i];
			if (ruppees == currentCoin) {
				coinMap.put(currentCoin, 1);
				break;
			} else if (currentCoin < ruppees) {
				while (true) {
					if (currentCoin > ruppees) {
						break;
					}
					if (currentCoin == ruppees) {
						coinMap.put(currentCoin, 1);
						break;
					}
					if (coinMap.containsKey(currentCoin)) {
						coinMap.put(currentCoin, coinMap.get(currentCoin) + 1);
						ruppees = ruppees - currentCoin;
					} else {
						coinMap.put(currentCoin, 1);
						ruppees = ruppees - currentCoin;
					}
				}
			}
		}
		return coinMap;
	}

	// sort method for practise
	public static void sortBasic(int[] coins) {

		for (int i = 0; i < coins.length - 1; i++) {
			int current = coins[i];
			for (int j = i + 1; j < coins.length - 1; j++) {
				int next = coins[j];
				if (next < current) {
					coins[i] = next;
					coins[j] = current;
				}
			}
		}
	}
	
	public static Map<Integer, Integer> findMinCoinToAddRuppeeAlgoSingleLoop(int[] coins, int ruppees) {
		// sorting is type fo greed
		// as we are forcing the same itme of array not to be traversed again
		sortBasic(coins);
		Map<Integer, Integer> coinMap = new HashMap<Integer, Integer>();
		int index = coins.length-1;
		while(true) {
			if(index <0) {
				break;
			}
			int currentCoin = coins[index];
			if (ruppees == currentCoin) {
				coinMap.put(currentCoin, 1);
				break;
			} 
			else if (currentCoin < ruppees) {
					if (coinMap.containsKey(currentCoin)) {
						coinMap.put(currentCoin, coinMap.get(currentCoin) + 1);
						ruppees = ruppees - currentCoin;
					} else {
						coinMap.put(currentCoin, 1);
						ruppees = ruppees - currentCoin;
					}
			}else if(ruppees < currentCoin) {
				index--;
			}
		}
		
		return coinMap;
	}
}
