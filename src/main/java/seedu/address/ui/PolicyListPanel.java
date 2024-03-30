package seedu.address.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import java.util.Set;

import seedu.address.model.person.Policy;

/**
 * Panel containing the list of policies.
 */
public class PolicyListPanel extends UiPart<Region> {
    private static final String FXML = "PolicyListPanel.fxml";

    @FXML
    private ListView<Policy> policyListView;

    // Constructor that accepts an ObservableList<Policy>
    public PolicyListPanel(ObservableList<Policy> policyList) {
        super(FXML);
        policyListView.setItems(policyList);
        policyListView.setCellFactory(listView -> new PolicyListViewCell());
    }

    // Additional constructor to handle Set<Policy>
    public PolicyListPanel(Set<Policy> policySet) {
        super(FXML);
        ObservableList<Policy> policyList = FXCollections.observableArrayList(policySet);
        policyListView.setItems(policyList);
        policyListView.setCellFactory(listView -> new PolicyListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Policy} using a {@code PolicyCard}.
     */
    class PolicyListViewCell extends ListCell<Policy> {
        @Override
        protected void updateItem(Policy policy, boolean empty) {
            super.updateItem(policy, empty);

            if (empty || policy == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PolicyCard(policy, getIndex() + 1).getRoot()); //TODO: WRONG!
            }
        }
    }
}
