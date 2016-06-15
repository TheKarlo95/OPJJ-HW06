package hr.fer.zemris.java.tecaj.hw6.demo3;

import java.util.Iterator;

@SuppressWarnings("javadoc")
public class PrimesCollection implements Iterable<Integer> {

    /**  */
    private int limit;

    public PrimesCollection(int limit) {
        this.limit = limit;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrimeIterator(limit);
    }

    @Override
    public String toString() {
        return "Limit = " + Integer.valueOf(limit);
    }

    private static class PrimeIterator implements Iterator<Integer> {

        /**  */
        private int currentPrime;

        /**  */
        private int currentIndex;

        /**  */
        private int limit;

        public PrimeIterator(int startNumber, int maxIndex) {
            if (startNumber < 1) {
                throw new IllegalArgumentException("Starting prime must be 1 or bigger!");
            }

            if (maxIndex < 0) {
                throw new IllegalArgumentException("Maximal index must be 0 or bigger!");
            }

            this.currentPrime = startNumber;
            this.currentIndex = 0;
            this.limit = maxIndex;
        }

        public PrimeIterator(int limit) {
            this(1, limit);
        }

        @Override
        public Integer next() {
            for (int i = currentPrime + 1; true; i++) {
                if (isPrime(i)) {
                    currentIndex++;
                    currentPrime = i;

                    return i;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return currentIndex < limit;
        }

        private boolean isPrime(int number) {
            for (int i = number - 1; i > 1; i--) {
                if (number % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
