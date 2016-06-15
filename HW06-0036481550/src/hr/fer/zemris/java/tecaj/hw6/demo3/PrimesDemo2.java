package hr.fer.zemris.java.tecaj.hw6.demo3;

/**
 * Second demonstration of a {@link PrimesCollection} class and its
 * capabilities.
 * 
 * <p>
 * Command-line arguments are not used.
 * 
 * @author Karlo Vrbić
 * @version 1.0
 * @see PrimesCollection
 */
public class PrimesDemo2 {

    /**
     * Starting point of a program.
     * 
     * @param args
     *            Command-line argument
     */
    public static void main(String[] args) {
        PrimesCollection primesCollection = new PrimesCollection(2);

        for (Integer prime : primesCollection) {
            for (Integer prime2 : primesCollection) {
                System.out.println("Got prime pair: " + prime + ", " + prime2);
            }
        }

    }

}
