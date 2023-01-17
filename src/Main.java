import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Задача 1:
        System.out.println("Задача 1:");

        Predicate<Integer> testNumber = num -> num > 0;
        System.out.println(testNumber.test(-1));
        System.out.println(testNumber.test(0));
        System.out.println(testNumber.test(91));

        Predicate<Integer> predicate = new Predicate<>() {
            @Override
            public boolean test(Integer num) {
                return num > 0;
            }

        };
        System.out.println("___");
        System.out.println(predicate.test(1));
        System.out.println(predicate.test(-12));
        System.out.println(predicate.test(0));

        // Задача 2:
        System.out.println();
        System.out.println("Задача 2:");

        Person person1 = new Person("John");

        Consumer<Person> consumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Привет " + person.getName());
            }
        };
        consumer.accept(person1);
        System.out.println("___");
        Consumer<Person> newConsumer = person -> System.out.println("Hello " + person.getName());
        newConsumer.accept(person1);

        //Задача 3:
        System.out.println();
        System.out.println("Задача 3:");

        Double doubleNum = 12.1;
        Function<Double, Long> function1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        System.out.println(function1.apply(doubleNum));
        System.out.println("___");

        Function<Double, Long> function = Double::longValue;
        System.out.println(function.apply(doubleNum));


        // Задача 4:
        System.out.println();
        System.out.println("Задача 4:");
        Random random = new Random();
        Supplier<Integer> supplier = () -> random.nextInt(100);
        System.out.println(supplier.get());
        System.out.println("___");

        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return random.nextInt(100);
            }
        };
        System.out.println(supplier1.get());

        // Задача 5:
        System.out.println();
        System.out.println("Задача 5:");
        Integer num = 100;
        Predicate<Integer> predicate1 = x -> x >= 0;
        Function<Integer, String> positive = x -> x + " число является положительным";
        Function<Integer, String> negative = x -> x + " число является отрицательным";
        System.out.println(ternaryOperator(predicate1, positive, negative).apply(num));

    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
            Function<T, U> function = new Function<T, U>() {
                @Override
                public U apply(T t) {
                    if (condition.test(t)) {
                        return ifTrue.apply(t);
                    } else {
                        return ifFalse.apply(t);
                    }
                }
            };
        return function;
    }
}

