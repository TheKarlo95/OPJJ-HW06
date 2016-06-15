package hr.fer.zemris.java.tecaj.hw6.demo2;

import java.util.Optional;

/**
 * Second demonstration of a {@link LikeMedian} class and its capabilities.
 * 
 * <p>
 * Command-line arguments are not used.
 * 
 * @author Karlo Vrbić
 * @version 1.0
 * @see LikeMedian
 */
public class MedianDemo2 {

    /**
     * Starting point of a program.
     * 
     * @param args
     *            Command-line argument
     */
    public static void main(String[] args) {
        LikeMedian<String> likeMedian = new LikeMedian<String>();

        likeMedian.add("Joe");
        likeMedian.add("Jane");
        likeMedian.add("Adam");
        likeMedian.add("Zed");

        Optional<String> result = likeMedian.get();

        System.out.println(result.get()); // Writes: Jane

    }

}
