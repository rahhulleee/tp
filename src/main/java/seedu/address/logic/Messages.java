package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.parser.Prefix;
import seedu.address.model.person.Person;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Use only the following Commands:\n"
            + "help \n"
            + "add \n"
            + "list \n"
            + "edit \n"
            + "find \n"
            + "delete \n"
            + "view \n"
            + "addPolicy \n"
            + "delPolicy \n"
            + "findPolicy \n"
            + "meetings \n"
            + "clear \n"
            + "exit";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT =
            "Insufficient/Invalid fields entered! Please check your inputs. \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The client index provided is invalid.";
    public static final String MESSAGE_INVALID_MEETING_DISPLAYED_INDEX = "The meeting index provided is invalid.";
    public static final String MESSAGE_DUPLICATE_POLICY_NUMBER = "The client already has this policy number.";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";
    public static final String MESSAGE_INVALID_POLICY = "The indexed person does not have the specified policy number";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        return new ToStringBuilder(person.getName().toString())
                .add("phone", person.getPhone())
                .add("email", person.getEmail())
                .add("address", person.getAddress())
                .add("meeting", person.getMeeting())
                .add("tags", person.getTags())
                .add("policies", person.getPolicies())
                .toString();
    }

}
