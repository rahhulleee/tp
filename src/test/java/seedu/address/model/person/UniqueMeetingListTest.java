package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.exceptions.DuplicateMeetingException;
import seedu.address.model.person.exceptions.MeetingNotFoundException;
import seedu.address.testutil.TypicalMeetings;

public class UniqueMeetingListTest {

    private final UniqueMeetingList uniqueMeetingList = new UniqueMeetingList();

    @Test
    public void contains_nullMeeting_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMeetingList.contains(null));
    }

    @Test
    public void contains_meetingNotInList_returnsFalse() {
        assertFalse(uniqueMeetingList.contains(TypicalMeetings.ALICEM));
    }

    @Test
    public void contains_meetingInList_returnsTrue() {
        Meeting meetingToAdd = TypicalMeetings.ALICEM;
        uniqueMeetingList.add(meetingToAdd);
        assertTrue(uniqueMeetingList.contains(meetingToAdd));
    }

    @Test
    public void add_nullMeeting_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMeetingList.add(null));
    }

    @Test
    public void setMeeting_nullTargetMeeting_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMeetingList.setMeeting(null, TypicalMeetings.ALICEM));
    }

    @Test
    public void setMeeting_nullEditedMeeting_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMeetingList.setMeeting(TypicalMeetings.ALICEM, null));
    }

    @Test
    public void setMeeting_targetMeetingNotInList_throwsMeetingNotFoundException() {
        assertThrows(MeetingNotFoundException.class, ()
            -> uniqueMeetingList.setMeeting(TypicalMeetings.ALICEM, TypicalMeetings.ALICEM));
    }

    @Test
    public void setMeeting_editedMeetingIsSameMeeting_success() {
        uniqueMeetingList.add(TypicalMeetings.ALICEM);
        uniqueMeetingList.setMeeting(TypicalMeetings.ALICEM, TypicalMeetings.ALICEM);
        UniqueMeetingList expectedUniqueMeetingList = new UniqueMeetingList();
        expectedUniqueMeetingList.add(TypicalMeetings.ALICEM);
        assertEquals(expectedUniqueMeetingList, uniqueMeetingList);
    }

    @Test
    public void setMeeting_editedMeetingHasDifferentIdentity_success() {
        uniqueMeetingList.add(TypicalMeetings.ALICEM);
        // Assuming BENSONM is considered a different meeting identity from ALICEM
        uniqueMeetingList.setMeeting(TypicalMeetings.ALICEM, TypicalMeetings.BENSONM);
        UniqueMeetingList expectedUniqueMeetingList = new UniqueMeetingList();
        expectedUniqueMeetingList.add(TypicalMeetings.BENSONM);
        assertEquals(expectedUniqueMeetingList, uniqueMeetingList);
    }

    @Test
    public void setMeetings_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMeetingList.setMeetings((List<Meeting>) null));
    }

    @Test
    public void setMeetings_listWithDuplicateMeetings_throwsDuplicateMeetingException() {
        List<Meeting> listWithDuplicateMeetings = Arrays.asList(TypicalMeetings.ALICEM, TypicalMeetings.ALICEM);
        assertThrows(DuplicateMeetingException.class, () -> uniqueMeetingList.setMeetings(listWithDuplicateMeetings));
    }
}
