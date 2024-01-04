package be.kdg.java2;

import be.kdg.java2.database.MonsterDbDao;
import be.kdg.java2.service.MonstersService;
import be.kdg.java2.service.MonstersServiceImpl;
import be.kdg.java2.view.MonstersPresenter;
import be.kdg.java2.view.MonstersView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        MonsterDbDao monsterDbDao = MonsterDbDao.getInstance("database/monsters");
        MonstersService monstersService = new MonstersServiceImpl(monsterDbDao);
        MonstersView monstersView = new MonstersView();
        new MonstersPresenter(monstersView, monstersService);
        stage.setTitle("Monster groeiproject Java2");
        stage.setScene(new Scene(monstersView));
        stage.show();
    }
}
