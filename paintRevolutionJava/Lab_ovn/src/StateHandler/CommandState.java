package StateHandler;

import Command.Command;
import Command.CommandCentral;
import Command.CommandTarget;
import Factory.CommandFactory;
import SubjectObserver.CanvasClick;
import SubjectObserver.MyObservable;
import SubjectObserver.ToolSelect;
import models.SPrototype;
import models.SceneModel;

/**
 * Created by o_0 on 2017-03-09.
 */
public class CommandState {
    private String currentShape = null;
    private String currentTool = null;
//    private SPrototype prototype;
//    private SceneModel sceneModel;

    private CommandCentral commandCentral = new CommandCentral();
    CommandFactory commandFactory;

    public CommandState(CommandFactory commandFactory) {
//        this.prototype = prototype;
//        this.sceneModel = sceneModel;
        this.commandFactory = commandFactory;// new CommandFactory(prototype, sceneModel);
    }

    public void setToolSelectionObserver(MyObservable<ToolSelect> selectObserver) {
        selectObserver.getObserver().add(this, this::eventSelectTool);
    }


    public void setShapeSelectObserver(MyObservable<ToolSelect> selectObserver) {
        selectObserver.getObserver().add(this, this::eventSelectShapeTool);
    }

    public void setCanvasClickObserver(MyObservable<CanvasClick> canvasClickObserver) {
        canvasClickObserver.getObserver().add(this, this::eventClickedAt);
    }

    private void eventSelectTool(String name) {
        System.out.println("eventSelectTool: " + name);
        currentTool = name;

        if (currentTool.equals("Undo")) {
            commandCentral.undo();
        } else if (currentTool.equals("Redo")) {
            commandCentral.redo();
        }
    }

    private void eventClickedAt(double x, double y) {
        if (currentShape == null || currentTool == null) {
            return;
        }
//        Shape shape = prototype.create(currentShape);
//        if (shape == null) {return;}
        if (currentTool.equals("Create")) {
            Command createComand = commandFactory.getCreateComand();
            commandCentral.doCommand(createComand, new CommandTarget(x, y, currentShape));
        }
//
//        shape.setX(x);
//        shape.setY(y);
//
//        sceneModel.addShape(shape);
    }

    private void eventSelectShapeTool(String name) {
        currentShape = name;
    }

}
