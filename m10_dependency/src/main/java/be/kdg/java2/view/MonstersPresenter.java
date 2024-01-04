package be.kdg.java2.view;

import be.kdg.java2.Model.Monster;
import be.kdg.java2.exceptions.MonsterException;
import be.kdg.java2.service.MonstersService;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;

import java.time.LocalDate;

public class MonstersPresenter {
    MonstersView monstersView;
    MonstersService monstersService;

    public MonstersPresenter(MonstersView monstersView, MonstersService monstersService) {
        this.monstersView = monstersView;
        this.monstersService = monstersService;
        this.addEventHandlers();
        fillTable();
    }

    private void addEventHandlers(){
        monstersView.getSaveButton().setOnAction(event -> {
            try {
                monstersService.AddMonster(new Monster(
                        monstersView.getMonsterNameInputField().getText(),
                        Integer.parseInt(monstersView.getMonsterLevelInputField().getText()),
                        monstersView.getMonsterBirthdayInputField().getValue() != null ? monstersView.getMonsterBirthdayInputField().getValue() : LocalDate.now()
                ));
            } catch (MonsterException | IllegalArgumentException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to add Monster, error:\n" + e.getMessage()).showAndWait();
            }
            fillTable();
            monstersView.getMonsterBirthdayInputField().setValue(null);
        });
    }

    private void fillTable() {
        try {
            monstersView.getMonsterTable().setItems(FXCollections.observableList(monstersService.getAllMonsters()));
        } catch (MonsterException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to load the monster table, error:\n" + e.getMessage()).showAndWait();
        }
    }
}
