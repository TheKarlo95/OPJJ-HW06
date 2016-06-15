package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * {@code IntegerStorageObserver} is observer interface used to observer change
 * in {@link IntegerStorage} object.
 * 
 * @author Karlo Vrbić
 * @version 1.0
 */
public interface IntegerStorageObserver {

    /**
     * Method which is called when {@link IntegerStorage} object changes
     * {@code IntegerStorageObserver} is prescribed to it.
     * 
     * @param istorage
     *            reference to {@link IntegerStorage} which this observer is
     *            prescribed
     */
    public void valueChanged(IntegerStorageChange istorage);
}
