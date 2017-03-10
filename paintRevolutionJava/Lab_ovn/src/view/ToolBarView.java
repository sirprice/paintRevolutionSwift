package view;

import SubjectObserver.MySubject;
import SubjectObserver.ObserverImpl;
import SubjectObserver.ToolSelect;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import models.Shape;
import models.ToolDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cj on 2017-03-08.
 */
public class ToolBarView implements DrawView , MySubject<ToolSelect> {

    public static final int width = 200;
    public static final int heigh = 500;

    private List<ToggleButton> tools;
    private ToggleGroup toolToggleGroup;
    private VBox toolBar;
    private ObserverImpl<ToolSelect> observer;

    public ToolBarView() {
        this.observer = new ObserverImpl<ToolSelect>();
        setup();
    }


    private void setup(){

        toolBar = new VBox();
        toolBar.setPrefWidth(width);
        toolBar.setBorder(new Border(new BorderStroke(null,null,null, new BorderWidths(10))));
        tools = new ArrayList<>();
        toolToggleGroup = new ToggleGroup();


    }

    public ObserverImpl<ToolSelect> getObserver() {
        return observer;
    }
//
//    public ObserverImpl<ToolSelect> getObserver() {
//        return observer;
//    }

    public void setTools(List<ToolDescription> shapes) {
        toolBar.getChildren().removeAll(tools);
        tools = new ArrayList<>();
        for (ToolDescription s : shapes) {
            ToggleButton tg = new ToggleButton();
            tg.setToggleGroup(toolToggleGroup);
            tg.setText(s.getName());
            tg.setOnMouseClicked((a) -> {
                observer.notifyObservers(selected -> selected.selectTool(s.getName()));
            });
            //tg.setOnMouseClicked(onMouseClickHandler);
            tools.add(tg);
//            toolBar.getChildren().add(tg);

        }

        toolBar.getChildren().addAll(tools);
    }



//    Scene scene;
//
//    private void debugScene() {
//        StackPane mainPane = new StackPane();
//        //Canvas canvas = new Canvas(200,200);
//        mainPane.getChildren().add(toolBar);
//        this.scene = new Scene(mainPane, 200, 200);
//    }
//
//
//    public VBox getToolBar() {
//        return toolBar;
//    }

//    @Override
//    public void showScene(Stage rootStage) {
//        debugScene();
//        rootStage.setTitle("ToolBar");
//        rootStage.setScene(scene);
//        rootStage.sizeToScene();
//        rootStage.show();
//
//    }

//    @Override
//    public void setDelegate(SceneController controller) {
//
//    }

    @Override
    public void addMeToView(Pane pane) {
        pane.getChildren().add(toolBar);
    }

    @Override
    public void renderView(List<Shape> shapes) {

    }
}
