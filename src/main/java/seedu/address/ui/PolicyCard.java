package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Policy;

/**
 * An UI component that displays information of a {@code Policy}.
 */
public class PolicyCard extends UiPart<Region> {
    private static final String FXML = "PolicyCard.fxml";

    public final Policy policy;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label policyName;
    @FXML
    private Label policyType;
    @FXML
    private Label policyId;
    @FXML
    private Label premiumTerm;
    @FXML
    private Label premium;
    @FXML
    private Label benefit;

    /**
     * Creates a {@code PolicyCard} with the given {@code Policy} and index to display.
     */
    public PolicyCard(Policy policy, int displayedIndex) {
        super(FXML);
        this.policy = policy;
        id.setText(displayedIndex + ". ");
        policyName.setText(policy.getName());
        policyType.setText("Policy Type: " + policy.getType());
        policyId.setText("Policy Number: " + policy.getId());
        premiumTerm.setText("Premium term: " + policy.getTerm());
        premium.setText("Premium paid: " + policy.getPremium());
        benefit.setText("Policy benefit: " + policy.benefit);
    }
}
