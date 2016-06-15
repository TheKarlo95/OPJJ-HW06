package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * 
 * 
 * @author Karlo Vrbić
 * @version 1.0
 */
public class IntegerStorageChange {

    /** Storage for integers */
    private IntegerStorage storage;

    /** Old value of storage */
    private Integer oldValue;

    /** New value of storage */
    private Integer newValue;

    /**
     * Constructs a new {@code IntegerStorageChange} object from specified
     * storage, old value and new value.
     * 
     * @param storage
     *            storage for integers
     * @param oldValue
     *            old value of storage
     * @param newValue
     *            new value of storage
     */
    public IntegerStorageChange(IntegerStorage storage, Integer oldValue, Integer newValue) {
        this.storage = storage;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * Constructs a new {@code IntegerStorageChange} object from specified
     * storage.
     * 
     * @param storage
     *            storage for integers
     */
    public IntegerStorageChange(IntegerStorage storage) {
        this(storage, null, null);
    }

    /**
     * Returns the storage.
     * 
     * @return the storage
     */
    public IntegerStorage getIntegerStorage() {
        return storage;
    }

    /**
     * Returns the old value.
     * 
     * @return the old value
     */
    public int getOldValue() {
        return oldValue;
    }

    /**
     * Returns the new value.
     * 
     * @return the new value
     */
    public int getNewValue() {
        return newValue;
    }
}
