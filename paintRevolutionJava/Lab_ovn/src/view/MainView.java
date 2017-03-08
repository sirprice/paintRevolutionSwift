package view;

import controllers.MainViewController;
import controllers.SceneController;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by o_0 on 2017-02-17.
 */
public class MainView implements DrawView {
    private Scene scene ;

    public MainView() {
        setup();
    }

    private SceneController controller;

    private void setup() {

        StackPane mainPane = new StackPane();
        this.scene = new Scene(mainPane, 300, 275);
    }

    public void showScene(Stage rootStage) {

        rootStage.setTitle("Hello World");
        rootStage.setScene(scene);
        rootStage.sizeToScene();
        rootStage.show();
    }

    @Override
    public void setDelegate(SceneController controller) {
        this.controller = controller;
    }
}
