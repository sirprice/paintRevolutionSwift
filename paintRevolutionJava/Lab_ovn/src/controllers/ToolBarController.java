package controllers;

import SubjectObserver.MyObservable;
import SubjectObserver.ObserverImpl;
import SubjectObserver.ShapeAdded;
import SubjectObserver.ToolSelect;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Circle;
import models.SPrototype;
import models.SceneModel;
import view.ToolBarView;

import java.util.Random;

/**
 * Created by cj on 2017-03-08.
 */
public class ToolBarController implements SceneController {
    private ToolBarView toolBarView;
    private SPrototype model;

    public ToolBarController(SPrototype model,ToolBarView toolBarView) {
        this.toolBarView = toolBarView;
        this.model = model;

//        this.toolBarView.setTools(model.getShapes(),onMouseClickHandler());
        MyObservable<ToolSelect> selectObserverobserver = toolBarView.getObserver();
        MyObservable<ShapeAdded> observer = model.getObserver();
        observer.add(this,this::updateTools);
        selectObserverobserver.add(this,this::toolSelected);
        updateTools();
    }


    public void toolSelected(String name) {
        System.out.println("ToolBarController selected tool: " + name);
        //Random rand = new Random();
        //model.addShape(new Circle(rand.nextInt(250),rand.nextInt(250),rand.nextInt(250)));

    }

    public void updateTools() {
        this.toolBarView.setTools(model.getPrototypes());
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
