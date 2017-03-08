package view;

import controllers.SceneController;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cj on 2017-03-08.
 */
public class ToolBar implements DrawView {

    public static final int width = 200;
    public static final int heigh = 500;

    private List<ToggleButton> tools;
    private ToggleGroup toolToggleGroup;
    private VBox toolBar;


    public ToolBar() {
        setup();

    }

    private void setup(){

        toolBar = new VBox();
        tools = new ArrayList<>();
        toolToggleGroup = new ToggleGroup();


    }


    public void setTools(List<Shape> shapes) {
        tools = new ArrayList<>();
        for (Shape s : shapes) {
            ToggleButton tg = new ToggleButton();
            tg.setToggleGroup(toolToggleGroup);
            tg.setText(s.getName());
            tools.add(tg);
        }

        toolBar.getChildren().addAll(tools);
    }







    public VBox getToolBar() {
        return toolBar;
    }

    @Override
    public void showScene(Stage rootStage) {

    }

    @Override
    public void setDelegate(SceneController controller) {

    }

    @Override
    public void renderView(List<Shape> shapes) {

    }
}
