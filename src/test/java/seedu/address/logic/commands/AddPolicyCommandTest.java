package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.Policy;
import seedu.address.testutil.PersonBuilder;

public class AddPolicyCommandTest {
    public static final String VALID_POLICY_NAME = "SuperSaver";
    public static final String VALID_POLICY_TYPE = "Investment";
    public static final String VALID_POLICY_NUMBER = "10";
    public static final String VALID_PREMIUM_TERM = "Annually";
    public static final String VALID_PREMIUM = "3000";
    public static final String VALID_BENEFIT = "100000";
    private final Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_policyAcceptedByModel_addPolicySuccessful() {
        Person personToAddPolicyTo = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Policy policyToAdd = new Policy(VALID_POLICY_NAME, VALID_POLICY_TYPE, VALID_POLICY_NUMBER,
                VALID_PREMIUM_TERM, VALID_PREMIUM, VALID_BENEFIT);
        Person personAfterAddPolicy = new PersonBuilder(personToAddPolicyTo, policyToAdd).build();

        AddPolicyCommand newAddPolicyCommand = new AddPolicyCommand(INDEX_FIRST_PERSON, VALID_POLICY_NAME,
                VALID_POLICY_TYPE, VALID_POLICY_NUMBER, VALID_PREMIUM_TERM, VALID_PREMIUM, VALID_BENEFIT);
        String expectedMessage = String.format(AddPolicyCommand.MESSAGE_ADD_POLICY_SUCCESS,
                Messages.format(personAfterAddPolicy));

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(model.getFilteredPersonList().get(0), personAfterAddPolicy);

        assertCommandSuccess(newAddPolicyCommand, model, expectedMessage, expectedModel);
    }

}
