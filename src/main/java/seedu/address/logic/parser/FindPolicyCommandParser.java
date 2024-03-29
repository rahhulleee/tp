package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindPolicyCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.PolicyNameContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindPolicyCommand object.
 */
public class FindPolicyCommandParser implements Parser<FindPolicyCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindPolicyCommand
     * and returns a FindPolicyCommand object for execution.
     *
     * @param args The input arguments to be parsed.
     * @return A FindPolicyCommand object representing the command with its parsed arguments.
     * @throws ParseException If the user input does not conform to the expected format.
     */
    public FindPolicyCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPolicyCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindPolicyCommand(new PolicyNameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }
}
