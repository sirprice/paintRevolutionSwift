package controllers;

import SubjectObserver.ObserverImpl;
import SubjectObserver.ShapeAdded;
import SubjectObserver.ToolSelect;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Circle;
import models.SceneModel;
import view.ToolBarView;

import java.util.Random;

/**
 * Created by cj on 2017-03-08.
 */
public class ToolBarController implements SceneController {
    private ToolBarView toolBarView;
    private SceneModel model;

    public ToolBarController(SceneModel model,ToolBarView toolBarView) {
        this.toolBarView = toolBarView;
        this.model = model;

//        this.toolBarView.setTools(model.getShapes(),onMouseClickHandler());
        ObserverImpl<ToolSelect> selectObserverobserver = toolBarView.getObserver();
        ObserverImpl<ShapeAdded> observer = model.getObserver();
        observer.add(this,this::updateTools);
        selectObserverobserver.add(this,this::toolSelected);
        updateTools();
    }


    public void toolSelected(int toolId) {
        System.out.println("ToolBarController selected tool: " + toolId);
        Random rand = new Random();
        model.addShape(new Circle(rand.nextInt(250),rand.nextInt(250),rand.nextInt(250)));

    }

    public void updateTools() {
        this.toolBarView.setTools(model.getShapes());
    }

    private EventHandler<MouseEvent> onMouseClickHandler() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
            }
        };

    }

    @Override
    public void showScene(Stage rootStage) {
//        toolBarView.showScene(rootStage);
    }

    @Override
    public void drawScene() {
//        toolBarView.renderView();
    }
}
