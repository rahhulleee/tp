package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;
import seedu.address.model.person.Policy;

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
    private Label policyId; // Add more labels or UI components as needed

    public PolicyCard(Policy policy, int displayedIndex) {
        super(FXML);
        this.policy = policy;
        id.setText(displayedIndex + ". ");
        policyName.setText(policy.getName());
        policyId.setText(policy.getId()); // Assuming these methods exist in your Policy class
        // Initialize other UI components here as needed
    }
}

