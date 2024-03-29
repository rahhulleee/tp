package seedu.address.model.person.exceptions;

/**
 * Signals that the operation will result in duplicate Meetings (Meetings are considered duplicates if they have the
 * same identity).
 */
public class DuplicateMeetingException extends RuntimeException {
    /**
     * Constructs a DuplicateMeetingException with a default error message.
     */
    public DuplicateMeetingException() {
        super("Operation would result in duplicate Meetings");
    }
}
