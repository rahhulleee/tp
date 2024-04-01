package seedu.address.logic.commands;

import java.util.Set;

import seedu.address.model.person.Policy;

/**
 * Represents the result of a view command execution that includes policies.
 */
public class ViewCommandResult extends CommandResult {

    private final Set<Policy> policies;

    /**
     * Constructs a {@code ViewCommandResult} with the specified feedback to user,
     * a set of policies, and other fields set to their default value.
     */
    public ViewCommandResult(String feedbackToUser, Set<Policy> policies) {
        super(feedbackToUser);
        this.policies = policies;
    }

    /**
     * Constructs a {@code ViewCommandResult} with all fields specified.
     */
    public ViewCommandResult(String feedbackToUser, boolean showHelp, boolean showMeetings,
                             boolean exit, Set<Policy> policies) {
        super(feedbackToUser, showHelp, showMeetings, exit);
        this.policies = policies;
    }

    public Set<Policy> getPolicies() {
        return policies;
    }

    // Override equals and hashCode if necessary

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) {
            return false;
        }
        if (!(other instanceof ViewCommandResult)) {
            return false;
        }
        ViewCommandResult otherResult = (ViewCommandResult) other;
        return policies.equals(otherResult.policies);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + policies.hashCode();
    }
}
