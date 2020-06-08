package goldman_problems;

import java.util.*;

public class _24BestAverageGrade {
    public static Integer bestAverageGrade(String[][] scores) {
        System.out.println(Arrays.deepToString(scores));
        Map<String, List<Integer>> nameScoreMap = new HashMap<>();
        Map<String, Integer> nameAverageMap = new HashMap<>();
        if (scores.length == 0 || scores[0].length == 0) {
            return 0;
        }

        //new average = old average + (next data - old average) / next count
        int count = 1;
        for (String[] scoreDetail : scores) {
            List<Integer> scoreList = nameScoreMap.getOrDefault(scoreDetail[0], new ArrayList<Integer>());
            scoreList.add(Integer.valueOf(scoreDetail[1]));
            nameScoreMap.put(scoreDetail[0], scoreList);
            int prevAverage = nameAverageMap.getOrDefault(scoreDetail[0], 0);
            int newAverage = prevAverage + (Integer.valueOf(scoreDetail[1]) - prevAverage) / count++;
            nameAverageMap.put(scoreDetail[0], newAverage);
        }

        System.out.println("nameScoreMap : \n " + nameScoreMap);
        System.out.println("nameAverageMap : \n " + nameAverageMap);


        //System.out.println("from new logic\t"+m);
        Integer bestAverage = Integer.MIN_VALUE;
        for (List<Integer> studentScores : nameScoreMap.values()) {
            Integer max = studentScores.stream().mapToInt(i -> i.intValue()).sum();
            bestAverage = Math.max(bestAverage, (int) (max / (studentScores.size() * 1.0)));
        }
        return bestAverage;
    }


    public static Integer bestAvgGrade(String[][] scores)
    {

        Map<String, Integer> scoreNameMap = new HashMap<>();

        for(String[] scoreDetails : scores) {

            String name = scoreDetails[0];
            int marks = Integer.parseInt(scoreDetails[1]);

            Integer preVal = scoreNameMap.get(name);
            if(preVal == null) {
                scoreNameMap.put(name, marks);
            } else {
                scoreNameMap.put(name, (preVal + marks)/2);
            }
        }

        System.out.println((scoreNameMap.values().stream().mapToInt(x -> x).max()).getAsInt());

        return (scoreNameMap.values().stream().mapToInt(x -> x).max()).getAsInt();
    }

    public static boolean doTestsPass() {
        Map<String[][], Integer> testCases = new HashMap<>();

        testCases.put(new String[][]{{"Bobby", "87"}, {"Charles", "100"}, {"Eric", "64"}, {"Charles", "22"}},
                87);
        testCases.put(new String[][]{}, 0);
        testCases.put(new String[][]{{}}, 0);

        testCases.put(new String[][]{{"Sarah", "91"}, {"Goldie", "92"}, {"Elaine", "93"}, {"Elaine", "95"},

                {"Goldie", "94"}, {"Sarah", "93"}}, 94);

        testCases.put(new String[][]{{"Janie", "-66"}, {"Janie", "0"}, {"Gina", "-88"}, {"Bobby", "0"},
                {"Gina", "44"}, {"Bobby", "0"}, {"Bobby", "-6"}}, -2);


        testCases.put(new String[][]{{"Alpha", "99"}, {"Bravo", "99"}, {"Charlie", "99"}, {"Delta", "99"},
                {"Echo", "99"}, {"Foxtrot", "99"}, {"Foxtrot", "99"}}, 99);
        testCases.put(new String[][]{{"Gerald", "91"}, {"Gerald", "92"}}, 91);
        testCases.put(new String[][]{{"Barry", "-66"}, {"Barry", "-65"}, {"Alfred", "-122"}}, -66);

        boolean passed = true;
        for (Map.Entry<String[][], Integer> entry : testCases.entrySet()) {
            Integer actual = bestAverageGrade(entry.getKey());
            if (actual != entry.getValue()) {
                passed = false;
                System.out.println("Failed for " + Arrays.deepToString(entry.getKey()) + "\n  expected "
                        + entry.getValue() + ", actual " + actual);
            }
        }

        return passed;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
