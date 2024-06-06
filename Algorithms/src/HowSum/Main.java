package HowSum;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(howSum(Arrays.asList(2L,3L), 7L, new HashMap<>()));
        System.out.println(howSum(Arrays.asList(5L,3L,4L,7L), 7L, new HashMap<>()));
        System.out.println(howSum(Arrays.asList(2L,4L), 7L, new HashMap<>()));
        System.out.println(howSum(Arrays.asList(2L,5L,3L), 8L, new HashMap<>()));
        System.out.println(howSum(Arrays.asList(7L,14L), 300L, new HashMap<>()));
    }

    public static List<Long> howSum(List<Long> numbers, Long targetSum, Map<Long, List<Long>> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;

        for(Long number : numbers) {
            Long reminder = targetSum - number;
            List<Long> reminderResult = howSum(numbers, reminder, memo);
            memo.put(targetSum, reminderResult);
            if(reminderResult != null) {
                reminderResult.add(number);
                return reminderResult;
            }
        }
        return null;
    }

}
