package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * {@code ChangeCounter} is implementation of {@link IntegerStorageObserver}
 * interface. It is a observer which counts the number of changes of value of
 * its {@link IntegerStorage} and prints a message to standard output informing
 * user about number of changes done since this observer is prescribed to
 * current storage.
 * 
 * @author Karlo Vrbić
 * @version 1.0
 * @see IntegerStorageObserver
 */
public class ChangeCounter implements IntegerStorageObserver {

    /** number of changes of value of its {@link IntegerStorage} */
    private int counter = 0;

    @Override
    public void valueChanged(IntegerStorageChange istorage) {
        System.out.printf("Number of value changes since tracking: %d%n", ++counter);
    }

}
