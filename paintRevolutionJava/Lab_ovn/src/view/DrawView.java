package view;

import javafx.scene.layout.Pane;
import models.Shape;

import java.util.List;

/**
 * Created by o_0 on 2017-02-17.
 */
public interface DrawView  {
//    public void showScene(Stage rootStage);
    public void addMeToView(Pane pane);
//    public void setDelegate(SceneController controller);
    public void renderView(List<Shape> shapes);
}
