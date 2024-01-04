package be.kdg.java2.view;


import be.kdg.java2.Model.Monster;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.time.LocalDate;

public class MonstersView extends BorderPane {
    private TableView<Monster> monsterTable;
    private TextField monsterNameInputField;
    private TextField monsterLevelInputField;
    private DatePicker monsterBirthdayInputField;
    private Button saveButton;


    public MonstersView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        monsterTable = new TableView<>();

        monsterNameInputField = new TextField();
        monsterNameInputField.setPromptText("Monster Name");

        monsterLevelInputField = new TextField();
        monsterLevelInputField.setPromptText("Monster Level");

        monsterBirthdayInputField = new DatePicker();
        monsterBirthdayInputField.setPromptText("Monster Birthday");

        saveButton = new Button("Save");
    }

    @SuppressWarnings("unchecked")
    private void layoutNodes() {
        super.setCenter(monsterTable);
        BorderPane.setMargin(monsterTable, new Insets(10));

        TableColumn<Monster, String> col1 = new TableColumn<>("Monster Name");
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Monster, LocalDate> col2 = new TableColumn<>("Monster Level");
        col2.setCellValueFactory(new PropertyValueFactory<>("level"));
        TableColumn<Monster, String> col3 = new TableColumn<>("Monster Birthday");
        col3.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        monsterTable.getColumns().addAll(col1, col2, col3);

        HBox hBox = new HBox(monsterNameInputField, monsterLevelInputField, monsterBirthdayInputField, saveButton);
        hBox.setSpacing(10);
        super.setBottom(hBox);
        BorderPane.setMargin(hBox, new Insets(10));
    }

    public TableView<Monster> getMonsterTable() {
        return monsterTable;
    }
    public TextField getMonsterNameInputField() {
        return monsterNameInputField;
    }
    public TextField getMonsterLevelInputField() {
        return monsterLevelInputField;
    }
    public DatePicker getMonsterBirthdayInputField() {
        return monsterBirthdayInputField;
    }
    public Button getSaveButton() {
        return saveButton;
    }

}
