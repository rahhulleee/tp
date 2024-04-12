package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewCommand object.
 */
public class ViewCommandParser implements Parser<ViewCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ViewCommand
     * and returns a ViewCommand object for execution.
     * @param args The arguments provided by the user for the view command.
     * @return A ViewCommand object representing the command to view a person's details.
     * @throws ParseException If the user input does not conform to the expected format.
     */
    public ViewCommand parse(String args) throws ParseException {
        requireNonNull(args);
        // Parse the index from the input arguments
        Index index = ParserUtil.parseIndex(args);
        if (index.getOneBased() <= 0) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_PERSON_DISPLAYED_INDEX)
            );
        }
        // Create and return a new ViewCommand with the parsed index
        return new ViewCommand(index);
    }
}

