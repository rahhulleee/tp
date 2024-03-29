package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s policies contain any of the keywords given.
 */
public class PolicyNameContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    /**
     * Constructs a PolicyNameContainsKeywordsPredicate with the specified keywords.
     *
     * @param keywords The list of keywords to be searched.
     */
    public PolicyNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Tests whether a given person's policies contain any of the keywords.
     *
     * @param person The person to test.
     * @return True if the person's policies contain any of the keywords, false otherwise.
     */
    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> person.getPolicies().stream()
                        .anyMatch(policy -> policy.policyName.toLowerCase().contains(keyword.toLowerCase())));
    }

    /**
     * Checks if this PolicyNameContainsKeywordsPredicate is equal to another object.
     *
     * @param other The other object to compare to.
     * @return True if the other object is equal to this PolicyNameContainsKeywordsPredicate, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PolicyNameContainsKeywordsPredicate)) {
            return false;
        }

        PolicyNameContainsKeywordsPredicate otherPolicyNameContainsKeywordsPredicate =
                (PolicyNameContainsKeywordsPredicate) other;
        return keywords.equals(otherPolicyNameContainsKeywordsPredicate.keywords);
    }


    /**
     * Returns a string representation of this PolicyNameContainsKeywordsPredicate.
     *
     * @return A string representation of this PolicyNameContainsKeywordsPredicate.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
