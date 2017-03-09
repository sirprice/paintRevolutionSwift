package StateHandler;

import SubjectObserver.CanvasClick;
import SubjectObserver.MyObservable;
import SubjectObserver.ObserverImpl;
import SubjectObserver.ToolSelect;
import models.SPrototype;
import models.SceneModel;
import models.Shape;

/**
 * Created by o_0 on 2017-03-09.
 */
public class CommandState {
    private String currentTool = null;
    private SPrototype prototype;
    private SceneModel sceneModel;

    public CommandState(SPrototype prototype, SceneModel sceneModel) {
        this.prototype = prototype;
        this.sceneModel = sceneModel;
    }

    public void setToolSelectionObserver(MyObservable<ToolSelect> selectObserver) {
        selectObserver.getObserver().add(this,this::eventSelectTool);
    }


    public void setShapeSelectObserver(MyObservable<ToolSelect> selectObserver) {
        selectObserver.getObserver().add(this,this::eventSelectShapeTool);
    }

    public void setCanvasClickObserver(MyObservable<CanvasClick> canvasClickObserver) {
        canvasClickObserver.getObserver().add(this,this::eventClickedAt);
    }

    private void eventSelectTool(String name) {
        System.out.println("eventSelectTool: " + name);
    }

    private void eventClickedAt(double x, double y) {
        if (currentTool == null) {return;}
        Shape shape = prototype.create(currentTool);
        if (shape == null) {return;}
        shape.setX(x);
        shape.setY(y);
        sceneModel.addShape(shape);
    }

    private void eventSelectShapeTool(String name) {
        currentTool = name;
    }

}
