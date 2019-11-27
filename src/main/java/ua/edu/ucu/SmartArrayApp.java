package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // answer: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // answer: [1, 2, 3]
        sa = new MapDecorator(sa, func); // answer: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] answer = sa.toArray();
        return Arrays.copyOf(answer, answer.length, Integer[].class);
    }
    public static String toString(Student student) {
        return student.getSurname() +  " " + student.getName();
    }
    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate pr1 = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student student = (Student)t;
                return student.getYear() == 2;
            }
        };

        MyPredicate pr2 = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student student = (Student)t;
                return student.getGPA() >= 4;
            }
        };
        MyComparator cmp1 = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student student1 = (Student)o1;
                Student student2 = (Student)o2;
                return student1.getSurname().compareTo(student2.getSurname());
            }
        };

        SmartArray stArr = new BaseArray(students);
        stArr = new DistinctDecorator(stArr);
        stArr = new FilterDecorator(stArr, pr1);
        stArr = new FilterDecorator(stArr, pr2);
        stArr = new SortDecorator(stArr, cmp1);
        Object[] answer = stArr.toArray();
        String[] res = new String[answer.length];
        for (int i = 0; i < answer.length; i++) {
            res[i] = toString((Student)answer[i]);
        }
        return res;
    }

}
