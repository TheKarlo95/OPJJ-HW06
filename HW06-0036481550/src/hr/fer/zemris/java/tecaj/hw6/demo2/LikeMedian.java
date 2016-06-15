package hr.fer.zemris.java.tecaj.hw6.demo2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("javadoc")
public class LikeMedian<T extends Comparable<T>> implements Iterable<T> {

    private List<T> elements;
    private List<T> sortedList;

    /**
     * Constructs a new {@code LikeMedian} with an empty list with the initial
     * capacity of ten.
     */
    public LikeMedian() {
        elements = new ArrayList<>();
        sortedList = new ArrayList<>();
    }

    /**
     * Appends the specified element to the end of internal list.
     * 
     * @param e
     *            element to be appended to internal list
     * @return {@code true} if internal list changed as a result of the call;
     *         {@code false} otherwise
     */
    public boolean add(T e) {
        sortedList.add(e);

        return elements.add(e);
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    public Optional<T> get() {
        if (elements.size() == 0) {
            return Optional.empty();
        }

        sortedList.sort((n1, n2) -> n1.compareTo(n2));
        return Optional.of(sortedList.get(Math.floorDiv(sortedList.size() - 1, 2)));
    }
}
