package CanSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {

        BiFunction<Long, List<Long>, Boolean> canSum = new BiFunction<>() {
            @Override
            public Boolean apply(Long targetSum, List<Long> numbers) {
                if(targetSum == 0) return true;
                if(targetSum < 0) return false;

                for(Long number : numbers) {
                    Long reminder = targetSum - number;
                    if(this.apply(reminder, numbers))//if you want not to include number itself you can remove it here before you pass it
                        return true;
                }
                return false;
            }
        };

        System.out.println(canSum.apply(7L, Arrays.asList(2L,3L))); //true
        System.out.println(canSum.apply(7L, Arrays.asList(5L,4L,3L,7L))); //true
        System.out.println(canSum.apply(7L, Arrays.asList(2L,4L))); //false
        System.out.println(canSum.apply(8L, Arrays.asList(2L,3L,5L))); //true
        //System.out.println(canSum.apply(300L, Arrays.asList(7L,14L))); //false
        System.out.println("--------------");
        System.out.println(canSumWithMemo(7L, Arrays.asList(2L,3L), new HashMap<>())); //true
        System.out.println(canSumWithMemo(7L, Arrays.asList(5L,4L,3L,7L), new HashMap<>())); //true
        System.out.println(canSumWithMemo(7L, Arrays.asList(2L,4L), new HashMap<>())); //false
        System.out.println(canSumWithMemo(8L, Arrays.asList(2L,3L,5L), new HashMap<>())); //true
        System.out.println(canSumWithMemo(300L, Arrays.asList(7L,14L), new HashMap<>())); //false

    }

    public static boolean canSumWithMemo(Long targetSum, List<Long> numbers, Map<Long, Boolean> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return true;
        if(targetSum < 0) return false;

        for(Long number : numbers) {
            Long reminder = targetSum - number;
            boolean bool = canSumWithMemo(reminder, numbers, memo);
            memo.put(reminder, bool);
            if(bool) return true;
        }
        return false;
    }
}
