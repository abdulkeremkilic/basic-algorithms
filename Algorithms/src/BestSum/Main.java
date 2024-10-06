package BestSum;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(bestSum(Arrays.asList(2L,3L), 7L, new HashMap<>()));
        System.out.println(bestSum(Arrays.asList(5L,3L,4L,7L), 7L, new HashMap<>()));
        System.out.println(bestSum(Arrays.asList(2L,4L), 7L, new HashMap<>()));
        System.out.println(bestSum(Arrays.asList(2L,5L,3L), 8L, new HashMap<>()));
        System.out.println(bestSum(Arrays.asList(7L,14L), 300L, new HashMap<>()));
    }

    public static List<Long> bestSum(List<Long> numbers, Long targetSum, Map<Long, List<Long>> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0)  return null;

        List<Long> shortestCombination = null;
        for(Long num : numbers) {
            Long reminder = targetSum - num;
            List<Long> reminderCombination = bestSum(numbers, reminder, memo);
            // if reminderCombination is not null there must be a bestSum
            // with the element we subtracted above.
            if(reminderCombination != null) {
                List<Long> combination = Stream.concat(reminderCombination.stream(), Stream.of(num)).toList();
                if(Objects.isNull(shortestCombination) || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                    memo.put(targetSum, shortestCombination);
                }
            }
        }
        return shortestCombination;
    }
}
