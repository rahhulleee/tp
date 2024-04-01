package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.PolicyNameContainsKeywordsPredicate;

/**
 * Finds and lists all persons in the address book who have policy names containing any of the specified keywords.
 */
public class FindPolicyCommand extends Command {

    public static final String COMMAND_WORD = "findPolicy";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Find person(s) with the input Policy Name linked to them.\n "
            + "Parameters: [POLICY NAME] (partial words are allowed and case-insensitive)\n"
            + "Example: " + COMMAND_WORD + " Saver ";

    private final PolicyNameContainsKeywordsPredicate predicate;


    /**
     * Constructs a FindPolicyCommand with the specified policy name predicate.
     *
     * @param predicate The predicate to filter persons based on policy name.
     */
    public FindPolicyCommand(PolicyNameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    /**
     * Executes the find policy command to filter the person list by policy name.
     *
     * @param model The model in which the person list is stored.
     * @return A CommandResult containing information about the execution of the command.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    /**
     * Checks if this FindPolicyCommand is equal to another object.
     *
     * @param other The other object to compare to.
     * @return True if the other object is equal to this FindPolicyCommand, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindPolicyCommand)) {
            return false;
        }

        FindPolicyCommand otherFindPolicyCommand = (FindPolicyCommand) other;
        return predicate.equals(otherFindPolicyCommand.predicate);
    }

    /**
     * Returns a string representation of this FindPolicyCommand.
     *
     * @return A string representation of this FindPolicyCommand.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
