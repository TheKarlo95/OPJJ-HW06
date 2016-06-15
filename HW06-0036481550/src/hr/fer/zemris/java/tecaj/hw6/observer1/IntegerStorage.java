package hr.fer.zemris.java.tecaj.hw6.observer1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Karlo Vrbić
 * @version 1.0
 */
public class IntegerStorage {

    /** Default size of the list containing observers */
    private static final int DEAFULT_NUM_OF_OBSERVERS = 4;

    /** Value this {@code IntegerStorage} is storing */
    private int value;

    /**
     * list of the observers currently prescribed to this {@code IntegerStorage}
     */
    private List<IntegerStorageObserver> observers;

    /**
     * Constructs a new {@code IntegerStorage} object from specified initial
     * value.
     * 
     * @param initialValue
     *            value to be stored in this storage
     */
    public IntegerStorage(int initialValue) {
        this.value = initialValue;
    }

    /**
     * Prescribes the specified observer to this {@code IntegerStorage}
     * 
     * @param observer
     *            observer which we want to prescribe to this storage
     */
    public void addObserver(IntegerStorageObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("You can't add null reference as observer!");
        }

        if (this.observers == null) {
            observers = new ArrayList<>(DEAFULT_NUM_OF_OBSERVERS);
        }

        this.observers.add(observer);
    }

    /**
     * Unprescribes the specified observer to this {@code IntegerStorage}.
     * 
     * @param observer
     *            observer which we want to prescribe to this storage
     */
    public void removeObserver(IntegerStorageObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("You can't remove null reference as observer!");
        }

        if (this.observers == null) {
            return;
        }

        this.observers.remove(observer);
    }

    /**
     * Clears all observers from this object. After execution of this method no
     * observer is observing this {@code IntegerStorage}.
     */
    public void clearObservers() {
        this.observers = null;
    }

    /**
     * Returns the value stored in this storage
     * 
     * @return the value stored in this storage
     */
    public int getValue() {
        return value;
    }

    /**
     * Stores the value in this storage and notifies the observer if change
     * happened. If the value you want to store is same as previously stoered
     * value observers will not be notified.
     * 
     * @param value
     *            the value to be stored in this storage
     */
    public void setValue(int value) {
        // Only if new value is different than the current value:
        if (this.value != value) {
            int oldValue = this.value;

            // Update current value
            this.value = value;

            // Notify all registered observers
            if (observers != null) {
                List<IntegerStorageObserver> removalList = new ArrayList<>(4);

                IntegerStorageChange change = new IntegerStorageChange(this, oldValue, this.value);

                for (IntegerStorageObserver observer : observers) {
                    try {
                        observer.valueChanged(change);
                    } catch (PostponeRemovalException e) {
                        removalList.add(observer);
                    }
                }

                removalList.forEach(o -> removeObserver(o));
            }
        }
    }
}
