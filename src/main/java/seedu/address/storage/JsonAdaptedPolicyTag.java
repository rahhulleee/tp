package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Policy;

/**
 * Jackson-friendly version of {@link Policy}.
 */
public class JsonAdaptedPolicyTag {
    public final String policyName;
    public final String policyType;
    public final String policyNumber;
    public final String premiumTerm;
    public final String premium;
    public final String benefit;


    /**
     * Constructs a {@code JsonAdaptedTag} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedPolicyTag(@JsonProperty("policyName") String policyName,
                                @JsonProperty("policyType") String policyType,
                                @JsonProperty("policyNumber") String policyNumber,
                                @JsonProperty("premiumTerm") String premiumTerm,
                                @JsonProperty("premium") String premium,
                                @JsonProperty("benefit") String benefit) {
        this.policyName = policyName;
        this.policyType = policyType;
        this.policyNumber = policyNumber;
        this.premiumTerm = premiumTerm;
        this.premium = premium;
        this.benefit = benefit;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedPolicyTag(Policy source) {
        policyName = source.policyName;
        policyType = source.policyType;
        policyNumber = source.policyNumber;
        premiumTerm = source.premiumTerm;
        premium = source.premium;
        benefit = source.benefit;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Policy toModelType() throws IllegalValueException {
        if (!Policy.isValidPolicyNameOrNumber(policyName)) {
            throw new IllegalValueException(Policy.POLICY_NAME_MESSAGE_CONSTRAINTS);
        }
        if (!Policy.isValidTypeOrPremiumOrBenefit(policyType)) {
            throw new IllegalValueException(Policy.POLICY_TYPE_MESSAGE_CONSTRAINTS);
        }
        if (!Policy.isValidPolicyNameOrNumber(policyNumber)) {
            throw new IllegalValueException(Policy.POLICY_NUMBER_MESSAGE_CONSTRAINTS);
        }
        if (!Policy.isValidPremiumTerm(premiumTerm)) {
            throw new IllegalValueException(Policy.PREMIUM_TERM_MESSAGE_CONSTRAINTS);
        }
        if (!Policy.isValidTypeOrPremiumOrBenefit(premium)) {
            throw new IllegalValueException(Policy.PREMIUM_MESSAGE_CONSTRAINTS);
        }
        if (!Policy.isValidTypeOrPremiumOrBenefit(benefit)) {
            throw new IllegalValueException(Policy.BENEFIT_MESSAGE_CONSTRAINTS);
        }
        return new Policy(policyName, policyType, policyNumber, premiumTerm, premium, benefit);
    }
}
