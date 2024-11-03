package today.streamapi.problems.oct29.newProb;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class NewProb {
    public static void main(String[] args) {


        /**
         * Q: Select only passed student.
         * Q: Add the 5 grace marks to all the failed student.
         * filter - will return true or false it means if input is 10 elements than output will be 10 elements
         * map - will return the same data that is if input has 10 elements it will return 10 elements we use map for transforming the data
         */

        List<Integer> list = Arrays.asList(10, 50, 75, 35, 25, 20, 40);
        List<Integer> passedStudent = list.stream().filter(i -> i > 35).collect(Collectors.toList());
//        System.out.println(passedStudent);

        List<Integer> failedStudentsAdded5graceMarks = list.stream().filter(i -> i < 35)
                .map(i -> i + 5)
                .collect(Collectors.toList());
        System.out.println(failedStudentsAdded5graceMarks);

    }
}
