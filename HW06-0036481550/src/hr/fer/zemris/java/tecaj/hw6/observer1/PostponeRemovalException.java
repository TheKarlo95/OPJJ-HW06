package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * {@code PostponeRemovalException} is the exception that can be thrown if you
 * need to remove observer but cannot do that normally. It is a subclass of
 * {@link RuntimeException}.
 * 
 * @author Karlo Vrbić
 * @version 1.0
 * @see RuntimeException
 */
public class PostponeRemovalException extends RuntimeException {

    /**
     * Serial
     */
    private static final long serialVersionUID = -7168151776921267516L;

    /**
     * Constructs a new {@code PostponeRemovalException} with {@code null} as
     * its detail message.
     */
    public PostponeRemovalException() {
        super();
    }

    /**
     * Constructs a new {@code PostponeRemovalException} with the specified
     * detail message.
     *
     * @param message
     *            the detail message. The detail message is saved for later
     *            retrieval by the {@link #getMessage()} method.
     */
    public PostponeRemovalException(String message) {
        super(message);
    }

}
