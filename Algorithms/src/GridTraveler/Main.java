package GridTraveler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        // [rows, columns]
        System.out.println(gridTraveler(1L,1L, new HashMap<>())); //1
        System.out.println(gridTraveler(2L,3L, new HashMap<>())); //3
        System.out.println(gridTraveler(3L,2L, new HashMap<>())); //3
        System.out.println(gridTraveler(3L,3L, new HashMap<>())); //6
        System.out.println(gridTraveler(18L,18L, new HashMap<>())); //2333606220


    }

    public static Long gridTraveler(Long m, Long n, Map<String, Long> memo) {
        String key = String.valueOf(m) + '-' + String.valueOf(n);
        if(memo.containsKey(key))
            return memo.get(key);

        if(m == 1 && n == 1)
            return 1L;
        if(m == 0 || n == 0)
            return 0L;

        memo.put(key, gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo));
        return memo.get(key);
    }
}
