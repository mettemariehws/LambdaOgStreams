import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        try (Stream<String> lines = Files.lines(Paths.get("Resources/Dat20Bstuderende.csv"), StandardCharsets.ISO_8859_1)){

            ArrayList<Student> students = new ArrayList<>();
            lines.forEach(s ->  students.add(new Student(s.split(";"))));

            //Group by classOrigin. Du bruger en sorted metode til at kunne få fat i comparator, der sorterer en student ud fra classorigin.
            //Derefter printer vi med forEach
            students.stream().sorted(Comparator.comparing(Student::getClassOrigin)).forEach(System.out::println);

            //Her sorterer vi en liste med eleverne efter lastname, metoden ved godt der skal være i natural order, du kunne lave en reverse hvis du vil have den modsat
            //Collect laver den til en liste vi kan printe ud
            List<Student> sortedList = students.stream()
                    .sorted(Comparator.comparing(Student::getLastname))
                    .collect(Collectors.toList());

            //print sortedList
            sortedList.forEach(s -> System.out.println(s.getLastname()));

            //tæl elever ud fra class origin
            Map<Character, List<Student>> groupedBy = students.stream()
                    .collect(Collectors.groupingBy(student -> student.getClassOrigin()));


            System.out.println(groupedBy.get('A').size());
            System.out.println(groupedBy.get('B').size());
            System.out.println(groupedBy.get('C').size());
            System.out.println(groupedBy.get('D').size());
            System.out.println(groupedBy.get('!').size());



        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
