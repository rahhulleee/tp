package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.Policy;

/**
 * Adds a policy to the client identified by the index number used in the last person listing
 * and the policy name.
 */
public class AddPolicyCommand extends Command {

    public static final String COMMAND_WORD = "addPolicy";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a policy to the client identified "
            + "by the index number used in the last person listing\n"
            + "and relevant fields. "
            + "Parameters: INDEX (must be a positive integer) "
            + "pol/POLICY_NAME type/POLICY_TYPE polnum/POLICY_ID\n"
            + "pterm/PREMIUM_TERM prem/POLICY_PREMIUM b/BENEFIT\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "pol/SuperSaver type/CI polnum/39376234 pterm/annually prem/3000 b/100000";

    public static final String MESSAGE_ADD_POLICY_SUCCESS = "Added policy to Person: %1$s";

    private final Index index;
    private final String policyName;
    private final String policyType;
    private final String policyNumber;
    private final String premiumTerm;
    private final String premium;
    private final String benefit;
    /**
     * Creates an AddPolicyCommand to add the specified {@code Policy} to the client at the specified index.
     *
     * @param index The index of the client in the filtered person list.
     * @param policyName The name of the policy to be added.
     */
    public AddPolicyCommand(Index index, String policyName, String policyType,
                            String policyNumber, String premiumTerm, String premium, String benefit) {
        requireAllNonNull(index, policyName, policyNumber, premiumTerm, premium, benefit);
        this.index = index;
        this.policyName = policyName;
        this.policyType = policyType;
        this.policyNumber = policyNumber;
        this.premiumTerm = premiumTerm;
        this.premium = premium;
        this.benefit = benefit;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        Set<Policy> currentPolicies = new HashSet<>(personToEdit.getPolicies());
        Policy newPolicy = new Policy(policyName, policyType, policyNumber, premiumTerm, premium, benefit);
        boolean policyExists = currentPolicies.stream()
                .anyMatch(policy -> policy.policyNumber.equals(newPolicy.policyNumber));

        if (policyExists) {
            throw new CommandException(Messages.MESSAGE_DUPLICATE_POLICY_NUMBER);
        }
        currentPolicies.add(newPolicy);

        Person editedPerson = new Person(
                personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), personToEdit.getMeeting(), personToEdit.getTags(), currentPolicies);

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        return new CommandResult(generateSuccessMessage(editedPerson));
    }

    private String generateSuccessMessage(Person editedPerson) {
        return String.format(MESSAGE_ADD_POLICY_SUCCESS, editedPerson);
    }
}
