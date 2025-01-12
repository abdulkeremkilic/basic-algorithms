package NumberToBinary;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(convertToBinary(55));
        System.out.println(convertToBinary2(55));
        System.out.println(convertToBinary2(102));
    }

    private static String convertToBinary(int number) {
        StringBuilder str = new StringBuilder();
        while (number != 0) {
            int binary = number % 2;
            str.insert(0, binary); //adds it like stack
            //you can add it with append and reverse it when you need to return it.
            number /= 2;
        }
        return str.toString();
    }

    public static String convertToBinary2(int number) {
        //Stream.iterate(initialValue, predicate, unaryOperator)
        String binary = Stream.iterate(number, n -> n > 0, n -> n / 2) //102 - 51 - 25 - 12 - 6 - 3 - 1
                .map(n -> String.valueOf(n % 2)) // 0,1,1,0,0,1,1 -> 102
                .reduce((bit, acc) -> bit + acc)//adds the strings together
                .orElse("0");

        return new StringBuilder(binary).reverse().toString();
    }
}
