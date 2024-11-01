package today.streamapi.problems.oct29.problem;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringProblemStream {
    public static void main(String[] args) {
        String input = "iloveJavatechie";
//        String[] results = input.split("");

        /**
         * 1. Java program to count the occurrence of each character in a string
         */

        Map<String, Long> result = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(result);


        /**
         * 2. Java program to find all duplicate element from a given string
         *
         *  Same question can be tricked by interviewer like to find the unique elements so that time just in filter we have to x.getValue() == 1
         */

        List<String> duplicateElements = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
//        System.out.println(duplicateElements);

        /**
         * Java program to find first non-repeat element from a given string
         *
         *  Suppose you want to get the first repeated character than we just have to update the filter like x -> x.getValue() > 1
         */

        String firstNonRepeatChar = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .findFirst().get().getKey();
//        System.out.println(firstNonRepeatChar);


        /**
         * Java program to find second highest number from given array
         *
         */

        /*if

        int[] numbers = {5,9,11,2,8,21,21,1};
        Then your logic will fail because...in reverse order it will show [21,21,11,9,8,5,1].....but second highest number is 11....but it will show 21.
        I think we need to add one more logic for remove duplicacy again then only it will show 11.

        int[] numbers = {5,9,11,2,8,21,21,1};
        Integer SecondHighestElement = Arrays.stream(numbers).boxed()
                .collect(Collectors.toSet()).stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(SecondHighestElement);*/

        int[] numbers = {5, 9, 11, 2, 8, 21, 1};

        Integer secondHighestNum = Arrays.stream(numbers).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
//        System.out.println(secondHighestNum);
        int[] numbers12 = {5, 9, 11, 2, 8, 21,21, 1};
        Integer secondHighenumIfDuplicateExists = Arrays.stream(numbers12).boxed().collect(Collectors.toSet())
                .stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(secondHighenumIfDuplicateExists);


        /**
         * Java program to find longest string from given array
         *
         */

        String[] strArray = {"Java","techie","springboot","microservices"};
        String longestString = Arrays.stream(strArray).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
//        System.out.println(longestString);

        /**
         * Java program to find all elements from array who starts with 1
         *
         */

        int[] num = {5, 9, 11, 2, 8, 21, 1};
        List<String> numStartsWith1 = Arrays.stream(num).boxed()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());
//        System.out.println(numStartsWith1);

        List<Integer> numStartWith1 = Arrays.stream(num).boxed()
                .filter(n -> n.toString().startsWith("1"))
                .collect(Collectors.toList());
//        System.out.println(numStartWith1);

        /**
         * String.join example
         *
         */

        List<String> nos = Arrays.asList("1", "2","3","4","5");
        //1-2-3-4-5

        String res = String.join("-", nos);
//        System.out.println(res);

        /**
         * Skip & limit method use case based example
         *
         */
//skip and limit example (2,9)

        /*IntStream.rangeClosed(1,10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);*/
    }


}
