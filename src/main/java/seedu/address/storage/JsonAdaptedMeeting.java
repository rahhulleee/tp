package seedu.address.storage;

import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Meeting;

/**
 * Jackson-friendly version of {@link Meeting}.
 */
public class JsonAdaptedMeeting {

    private final String name;
    private final String meetingDetail;

    /**
     * Constructs a {@code JsonAdaptedMeeting} with the given meeting detail and name.
     *
     * @param name          The name associated with the meeting.
     * @param meetingDetail A valid meeting detail.
     */
    @JsonCreator
    public JsonAdaptedMeeting(@JsonProperty("name") String name,
                              @JsonProperty("meetingDetail") String meetingDetail) {
        this.name = name;
        this.meetingDetail = meetingDetail;
    }

    /**
     * Converts a given {@code Meeting} into this class for Jackson use.
     *
     * @param source The source Meeting object to convert.
     */
    public JsonAdaptedMeeting(Meeting source) {
        this.name = source.getName();
        this.meetingDetail = source.getMeeting().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * Converts this Jackson-friendly adapted meeting object into the model's {@code Meeting} object.
     *
     * @return The converted Meeting object.
     * @throws IllegalValueException If there were any data constraints violated in the adapted meeting.
     */
    public Meeting toModelType() throws IllegalValueException {
        if (!Meeting.isValidMeeting(meetingDetail)) {
            throw new IllegalValueException(Meeting.MESSAGE_CONSTRAINTS);
        }
        Meeting meeting = new Meeting(meetingDetail);
        meeting.setName(this.name); // Assuming Meeting class has setName() method to set the name.
        return meeting;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("meetingDetail")
    public String getMeetingDetail() {
        return meetingDetail;
    }
}
