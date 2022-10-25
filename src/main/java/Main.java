import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        String[] names = new String[]{"Robert","Gucci" ,"John", "Alex", "Robert", "Robert", "Gucci", "Gucci"};

        Arrays.stream(names).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream()
                .forEach(stringLongEntry -> {
                    if (stringLongEntry.getValue() == Arrays.stream(names).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                            .entrySet().stream()
                            .max(Map.Entry.comparingByValue()).get().getValue())
                        System.out.print(stringLongEntry.getKey() + " ");
                });

        System.out.println();
        Person[] persons = new Person[]{
                new Person("Bob", 29, 82000),
                new Person("Bob1", 20, 75000),
                new Person("Bob2", 21, 60000),
                new Person("Bob3", 18, 120000),
                new Person("Bob4", 20, 72000)
        };

        System.out.println(Arrays.stream(persons).mapToDouble(Person::getSalary).average().getAsDouble());

        FindOld(persons, 3);

    }

    public static void FindOld(Person[] persons, int n)
    {
        System.out.println(
        Arrays.stream(persons)
                .sorted((o1, o2) -> o2.Age-o1.Age)
                .limit(n)
                .map(Person::getName)
                .collect(Collectors.joining(",", n + " самых старших сотрудников зовут: ", ".")));
    }
}
