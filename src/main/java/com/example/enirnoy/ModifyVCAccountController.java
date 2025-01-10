package com.example.enirnoy;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
public class ModifyVCAccountController {

        @FXML
        private ComboBox<String> userTypeComboBox;

        @FXML
        private TextField nidTextField;

        @FXML
        private TableView<Person> tableView;

        @FXML
        private TableColumn<Person, String> nidColumn;

        @FXML
        private TableColumn<Person, String> nameColumn;

        @FXML
        private TableColumn<Person, String> addressColumn;

        @FXML
        private Button modifyButton;

        // List to hold table data
        private final ObservableList<Person> personList = FXCollections.observableArrayList();

        // Initialize method
        @FXML
        public void initialize() {
            // Initialize ComboBox options
            userTypeComboBox.getItems().addAll("Voter", "Candidate");

            // Initialize TableView
            nidColumn.setCellValueFactory(cellData -> cellData.getValue().nidProperty());
            nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
            addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());

            // Add sample data to TableView (you can replace this with actual data)
            personList.add(new Person("1234567890", "John Doe", "123 Main St"));
            personList.add(new Person("9876543210", "Jane Smith", "456 Oak St"));

            tableView.setItems(personList);

            // Modify Button action
            modifyButton.setOnAction(event -> handleModifyAction());

            // Add listener to TextField for NID search
            nidTextField.setOnKeyReleased(this::handleSearchByNid);
        }

        // Modify action handler
        private void handleModifyAction() {
            // Get the selected person from the table
            Person selectedPerson = tableView.getSelectionModel().getSelectedItem();

            // Make sure a person is selected
            if (selectedPerson != null) {
                // Save changes (you can update the person object or save to database)
                // Here, we'll just show an alert for the purpose of the example
                String message = "Changes saved for: " + selectedPerson.getName();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
                alert.showAndWait();
            } else {
                // Show an error if no person is selected
                Alert alert = new Alert(Alert.AlertType.ERROR, "No person selected", ButtonType.OK);
                alert.showAndWait();
            }
        }

        // Handle searching by NID
        private void handleSearchByNid(KeyEvent event) {
            String searchNid = nidTextField.getText();

            // Filter the table data based on the NID entered in the text field
            ObservableList<Person> filteredList = FXCollections.observableArrayList();

            for (Person person : personList) {
                if (person.getNid().contains(searchNid)) {
                    filteredList.add(person);
                }
            }

            // Update the TableView with filtered data
            tableView.setItems(filteredList);
        }
    }

    // Person model class (for TableView data)
    class Person {
        private final SimpleStringProperty nid;
        private final SimpleStringProperty name;
        private final SimpleStringProperty address;

        public Person(String nid, String name, String address) {
            this.nid = new SimpleStringProperty(nid);
            this.name = new SimpleStringProperty(name);
            this.address = new SimpleStringProperty(address);
        }

        public String getNid() {
            return nid.get();
        }

        public SimpleStringProperty nidProperty() {
            return nid;
        }

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public String getAddress() {
            return address.get();
        }

        public SimpleStringProperty addressProperty() {
            return address;
        }
    }
