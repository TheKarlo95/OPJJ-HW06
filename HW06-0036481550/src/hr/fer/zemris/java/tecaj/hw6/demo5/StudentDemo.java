package hr.fer.zemris.java.tecaj.hw6.demo5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import hr.fer.zemris.java.tecaj.hw6.demo3.PrimesCollection;

/**
 * {@code StudentDemo} class is a Demonstration of a {@link Stream} class and
 * its capabilities.
 * <p>
 * Command-line arguments are not used.
 * 
 * @author Karlo Vrbić
 * @version 1.0
 * @see PrimesCollection
 */
public class StudentDemo {

    /**
     * Starting point of a program.
     * 
     * @param args
     *            Command-line argument
     * @throws IOException
     *             signals that an error has been reached unexpectedly while
     *             opening student records file.
     */
    public static void main(String[] args) throws IOException {
        List<StudentRecord> records = new ArrayList<>();

        for (String line : Files.readAllLines(Paths.get("./studenti.txt"))) {
            records.add(StudentRecord.fromString(line, "\t"));
        }

        long broj = records.stream().filter(s -> s.getTotalPoints() > 25).count();

        long broj5 = records.stream().filter(s -> s.getGrade() == 5).count();

        List<StudentRecord> odlikasi = records
                .stream()
                .filter(s -> s.getGrade() == 5)
                .collect(Collectors.toList());

        List<StudentRecord> odlikasiSortirano = records
                .stream()
                .filter(s -> s.getGrade() == 5)
                .sorted(StudentRecord.BY_TOTAL_POINTS)
                .collect(Collectors.toList());

        List<String> nepolozeniJMBAGovi = records
                .stream()
                .filter(s -> s.getGrade() == 1)
                .map(StudentRecord::getJMBAG)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Map<Integer, List<StudentRecord>> mapaPoOcjenama = records
                .stream()
                .collect(Collectors.groupingBy(StudentRecord::getGrade));

        Map<Integer, Integer> mapaPoOcjenama2 = records.stream().collect(
                Collectors.toMap(StudentRecord::getGrade, s -> 1, (s1, s2) -> s1 + s2));

        Map<Boolean, List<StudentRecord>> prolazNeprolaz = records
                .stream()
                .collect(Collectors.partitioningBy(s -> s.getGrade() != 1));

        System.out.printf("broj = %d%n%n", broj);
        System.out.printf("broj5 = %d%n%n", broj5);
        System.out.printf("odlikasi = " + listToString(odlikasi) + "%n%n");
        System.out.printf("odlikasiSortirano = " + listToString(odlikasiSortirano) + "%n%n");
        System.out.printf("nepolozeniJMBAGovi = " + listToString(nepolozeniJMBAGovi) + "%n%n");
        System.out.printf("mapaPoOcjenama = " + mapToString(mapaPoOcjenama) + "%n%n");
        System.out.printf("mapaPoOcjenama2 = " + mapToString(mapaPoOcjenama2) + "%n%n");
        System.out.printf("prolazNeprolaz = " + mapToString(prolazNeprolaz) + "%n%n");

    }

    /**
     * A little bit different {@code toString()} method for returning a string
     * representation of a list.
     * 
     * @param list
     *            list which is going to be turned to string
     * @return string representation of a specified list
     */
    private static <T> String listToString(List<T> list) {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (T entry : list) {
            sb.append("%n");
            sb.append(entry.toString());
        }

        sb.append("%n}");

        return sb.toString();
    }

    /**
     * A little bit different {@code toString()} method for returning a string
     * representation of a map.
     * 
     * @param map
     *            map which is going to be turned to string
     * @return string representation of a specified map
     */
    @SuppressWarnings("unchecked")
    private static <K, V, T> String mapToString(Map<K, V> map) {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb.append("%n");
            sb.append(entry.getKey().toString());
            sb.append(", ");
            if (entry.getValue() instanceof List) {
                sb.append(listToString((List<T>) entry.getValue()));
            } else {
                sb.append(entry.getValue().toString());
            }
        }

        sb.append("}");

        return sb.toString();
    }
}