package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class MeetingTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Meeting(null));
    }

    @Test
    public void constructor_invalidMeeting_illegalArugmentException() {
        String invalidMeeting = "";
        assertThrows(IllegalArgumentException.class, () -> new Meeting(invalidMeeting));
    }

    @Test
    public void stringToDateTime_invalidInput_throwsIllegalArgumentException() {
        // EP: Invalid month, day or time
        String invalidMeeting1 = "2025-01-01 25:00";
        assertThrows(IllegalArgumentException.class, () -> new Meeting(invalidMeeting1));

        String invalidMeeting2 = "2025-13-01 00:30";
        assertThrows(IllegalArgumentException.class, () -> new Meeting(invalidMeeting2));

        String invalidMeeting3 = "2025-01-32 00:00";
        assertThrows(IllegalArgumentException.class, () -> new Meeting(invalidMeeting3));

        // EP: Missing fields
        String invalidMeeting4 = "2025-01 10:00";
        assertThrows(IllegalArgumentException.class, () -> new Meeting(invalidMeeting4));

        String invalidMeeting5 = "01-01 10:00";
        assertThrows(IllegalArgumentException.class, () -> new Meeting(invalidMeeting5));

        // EP: Invalid format
        String invalidMeeting6 = "01-01-2024 10:00";
        assertThrows(IllegalArgumentException.class, () -> new Meeting(invalidMeeting6));

        String invalidMeeting7 = "2025-01-01 10:00:00";
        assertThrows(IllegalArgumentException.class, () -> new Meeting(invalidMeeting7));

        // EP: String is not a valid meeting
        String invalidMeeting8 = " ";
        assertThrows(IllegalArgumentException.class, () -> new Meeting(invalidMeeting8));

        String invalidMeeting9 = "Not a meeting";
        assertThrows(IllegalArgumentException.class, () -> new Meeting(invalidMeeting9));
    }

    @Test
    public void isValidMeeting() {
        // valid meeting
        assertTrue(Meeting.isValidMeeting("2001-01-12 12:30"));
        assertTrue(Meeting.isValidMeeting("2025-01-01 00:00"));

        // invalid month, day or time
        assertFalse(Meeting.isValidMeeting("2025-99-01 00:00")); // invalid month
        assertFalse(Meeting.isValidMeeting("2025-01-99 00:00")); // invalid day
        assertFalse(Meeting.isValidMeeting("2025-01-01 25:00")); // invalid time
        assertFalse(Meeting.isValidMeeting("2025-01-01 00:60")); // invalid time

        // null meeting
        assertThrows(NullPointerException.class, () -> Meeting.isValidMeeting(null));

        // missing parts
        assertFalse(Meeting.isValidMeeting("2024 10:00")); // missing MM-DD and time
        assertFalse(Meeting.isValidMeeting("2024-01")); // missing DD and time
        assertFalse(Meeting.isValidMeeting("01-12")); // missing YYYY and time
    }

    /**
     * Test if the meeting is a future meeting.
     * This test is dependent on the testing system's current date and time.
     * Assumption: The testing system's current date and time is between 2024 and 2025.
     */
    @Test
    public void isFutureMeeting() {
        // past meeting
        assertFalse(Meeting.isFutureMeeting("2020-01-01 00:00"));

        // future meeting
        assertTrue(Meeting.isFutureMeeting("2026-04-08 00:00"));
    }

    @Test
    public void setName() {
        // Initialize name as "Jim"
        Meeting meeting = new Meeting("2025-01-01 10:00", "Jim");
        assertTrue(meeting.getName().equals("Jim"));

        // Set name to "Rahul"
        meeting.setName("Rahul");
        assertTrue(meeting.getName().equals("Rahul"));
    }

    @Test
    public void equals() {
        Meeting meeting = new Meeting("2025-01-01 00:00");

        // same values -> returns true
        assertTrue(meeting.equals(new Meeting("2025-01-01 00:00")));

        // same object -> returns true
        assertTrue(meeting.equals(meeting));

        // null -> returns false
        assertFalse(meeting.equals(null));

        // different types -> returns false
        assertFalse(meeting.equals(5.0f));

        // different values -> returns false
        assertFalse(meeting.equals(new Meeting("2025-01-02 12:30")));
    }
}
