package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * {@code SquareValue} is implementation of {@link IntegerStorageObserver}
 * interface. It is a observer which calculates the square of value of its
 * {@link IntegerStorage} and prints it to standard output with appropriate
 * message(e.g. "Provided new value: 2, square is 4").
 * 
 * @author Karlo Vrbić
 * @version 1.0
 * @see IntegerStorageObserver
 */
public class SquareValue implements IntegerStorageObserver {

    @Override
    public void valueChanged(IntegerStorageChange istorage) {
        System.out.printf(
                "Provided new value: %d, square is %d%n",
                istorage.getNewValue(),
                ((Number) Math.pow(istorage.getNewValue(), 2)).intValue());
    }

}
