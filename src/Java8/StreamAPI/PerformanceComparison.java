package Java8.StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerformanceComparison {
    /** Similar Outputs
     * Traditional approach time: 245 ms
     * Stream API approach time: 109 ms
     * Parallel Stream API approach time: 2082 ms
     * @param args
     */
    public static void main(String[] args){
        int size = 10_000_000;
        ArrayList<Integer> numbers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        // Measure time for traditional approach
        long startTime = System.currentTimeMillis();
        List<Integer> evenNumbersTraditional = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbersTraditional.add(number);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Traditional approach time: " + (endTime - startTime) + " ms");

        // Measure time for Stream API approach
        startTime = System.currentTimeMillis();
        List<Integer> evenNumbersStream = numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        endTime = System.currentTimeMillis();
        System.out.println("Stream API approach time: " + (endTime - startTime) + " ms");

        // Measure time for Parallel Stream API approach
        startTime = System.currentTimeMillis();
        List<Integer> evenNumbersParallelStream = numbers.parallelStream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        endTime = System.currentTimeMillis();
        System.out.println("Parallel Stream API approach time: " + (endTime - startTime) + " ms");
    }
}
