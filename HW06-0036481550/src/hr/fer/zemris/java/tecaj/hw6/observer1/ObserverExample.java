package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * {@code ObserverExample} is a class which is used to demonstrate
 * {@link IntegerStorage} and {@link IntegerStorageObserver} class. Command-line
 * arguments are not used in this program.
 * 
 * @author Karlo Vrbić
 * @version 1.0
 */
public class ObserverExample {

    /**
     * Starting point of a program.
     * 
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        IntegerStorage istorage = new IntegerStorage(20);

        istorage.addObserver(new SquareValue());
        istorage.addObserver(new ChangeCounter());
        istorage.addObserver(new DoubleValue(6));

        System.out.println("*****************************************|");
        istorage.setValue(5);
        System.out.println("*****************************************|");
        istorage.setValue(2);
        System.out.println("*****************************************|");
        istorage.setValue(25);
        System.out.println("*****************************************|");

        istorage.setValue(13);
        System.out.println("*****************************************|");
        istorage.setValue(22);
        System.out.println("*****************************************|");
        istorage.setValue(15);
        System.out.println("*****************************************|");
    }
}