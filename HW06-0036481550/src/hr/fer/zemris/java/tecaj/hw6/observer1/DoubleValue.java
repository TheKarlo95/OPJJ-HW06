package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * {@code DoubleValue} is implementation of {@link IntegerStorageObserver}
 * interface. It is a observer which calculates the value of its
 * {@link IntegerStorage} multiplied by 2 first n-times and prints it to
 * standard output with appropriate message(e.g. "Double value: 4").
 * 
 * @author Karlo Vrbić
 * @version 1.0
 * @see IntegerStorageObserver
 */
public class DoubleValue implements IntegerStorageObserver {

    /**
     * Default number of times this observer will print value from
     * {@link IntegerStorage} multiplied by 2.
     */
    private static final int DEFAULT_NUMBER_OF_OCCURENCES = 1;

    /**
     * Number of times this observer will print value from
     * {@link IntegerStorage} multiplied by 2.
     */
    private int n;

    /**
     * Constructs a new {@code DoubleValue} observer using specified n.
     * 
     * @param n
     *            number of times this observer will print value from
     *            {@link IntegerStorage} multiplied by 2.
     */
    public DoubleValue(int n) {
        this.n = n;
    }

    /**
     * Constructs a new {@code DoubleValue} observer which will print the value
     * of its {@link IntegerStorage} multiplied by 2
     * {@value #DEFAULT_NUMBER_OF_OCCURENCES} times.
     */
    public DoubleValue() {
        this(DEFAULT_NUMBER_OF_OCCURENCES);
    }

    @Override
    public void valueChanged(IntegerStorageChange istorage) {
        if (n-- <= 0) {
            throw new PostponeRemovalException();
        }

        System.out.printf("Double value: %d%n", istorage.getNewValue() * 2);
    }

}
