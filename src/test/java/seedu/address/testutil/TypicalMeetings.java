package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.AMY;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.DANIEL;
import static seedu.address.testutil.TypicalPersons.ELLE;
import static seedu.address.testutil.TypicalPersons.FIONA;
import static seedu.address.testutil.TypicalPersons.GEORGE;
import static seedu.address.testutil.TypicalPersons.HOON;
import static seedu.address.testutil.TypicalPersons.IDA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Meeting;

/**
 * A utility class containing a list of {@code Meeting} objects to be used in tests.
 */
public class TypicalMeetings {
    public static final Meeting ALICEM = ALICE.getMeeting();
    public static final Meeting BENSONM = BENSON.getMeeting();
    public static final Meeting CARLM = CARL.getMeeting();
    public static final Meeting DANIELM = DANIEL.getMeeting();
    public static final Meeting ELLEM = ELLE.getMeeting();
    public static final Meeting FIONAM = FIONA.getMeeting();
    public static final Meeting GEORGEM = GEORGE.getMeeting();

    // Manually added
    public static final Meeting HOONM = HOON.getMeeting();
    public static final Meeting IDAM = IDA.getMeeting();

    // Manually added - Meeting's details found in {@code CommandTestUtil}
    public static final Meeting AMYM = AMY.getMeeting();
    public static final Meeting BOBM = BOB.getMeeting();

    private TypicalMeetings() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical meetings.
     */
    public static AddressBook getTypicalAddressBookMeetings() {
        AddressBook ab = new AddressBook();
        for (Meeting meeting : getTypicalMeetings()) {
            ab.addMeeting(meeting);
        }
        return ab;
    }

    public static List<Meeting> getTypicalMeetings() {
        return new ArrayList<>(Arrays.asList(ALICEM, BENSONM, CARLM, DANIELM, ELLEM, FIONAM, GEORGEM));
    }
}
