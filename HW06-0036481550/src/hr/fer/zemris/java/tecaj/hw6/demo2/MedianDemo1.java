package hr.fer.zemris.java.tecaj.hw6.demo2;

import java.util.Optional;

/**
 * First demonstration of a {@link LikeMedian} class and its capabilities.
 * 
 * <p>
 * Command-line arguments are not used.
 * 
 * @author Karlo Vrbić
 * @version 1.0
 * @see LikeMedian
 */
public class MedianDemo1 {

    /**
     * Starting point of a program.
     * 
     * @param args
     *            Command-line argument
     */
    public static void main(String[] args) {
        LikeMedian<Integer> likeMedian = new LikeMedian<Integer>();

        likeMedian.add(new Integer(10));
        likeMedian.add(new Integer(5));
        likeMedian.add(new Integer(3));

        Optional<Integer> result = likeMedian.get();

        System.out.println(result.get());

        for (Integer elem : likeMedian) {
            System.out.println(elem);
        }
    }
}
