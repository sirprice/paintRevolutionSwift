package StateHandler;

import Command.Command;
import Command.CommandCentral;
import Command.CommandTarget;
import Factory.CommandFactory;
import SubjectObserver.CanvasClick;
import SubjectObserver.MyObservable;
import SubjectObserver.ObserverShapeProperties;
import SubjectObserver.ToolSelect;
import javafx.scene.paint.Color;
import models.Shape;
import models.ShapeProperties;

/**
 * Created by o_0 on 2017-03-09.
 */
public class CommandState {
    private String currentShape = null;
    private String currentTool = null;
    private Shape selectedShape = null;
    private ActiveSelections activeSelections = new ActiveSelections();

    //    private SPrototype prototype;
//       private SceneModel sceneModel;

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

    public void setShapePropertyObserver(MyObservable<ObserverShapeProperties> selectObserver) {
        selectObserver.getObserver().add(this, this::eventShapePropertiesChanged);
    }


    public void setShapeSelectObserver(MyObservable<ToolSelect> selectObserver) {
        selectObserver.getObserver().add(this, this::eventSelectShapeTool);
    }

    public void setCanvasClickObserver(MyObservable<CanvasClick> canvasClickObserver) {
        canvasClickObserver.getObserver().add(this, this::eventClickedAt);
    }

    private void eventShapePropertiesChanged(Color color, boolean isFilled, double lineWidth){
        Command command = commandFactory.getChangePropertiesCommand(new ShapeProperties(color,isFilled,lineWidth));
        commandCentral.doCommand(command, new CommandTarget(0, 0, currentShape, activeSelections));

    }

    private void eventSelectTool(String name) {
        System.out.println("eventSelectTool: " + name);
        currentTool = name;

        if (currentTool.equals("Undo")) {
            commandCentral.undo();
        } else if (currentTool.equals("Redo")) {
            commandCentral.redo();
        } else if (currentTool.equals("New")) {
            commandFactory.getNewDocumentCommand().execute(null);
            commandCentral.clearHistory();

        } else if (currentTool.equals("Load")) {
            //
        } else if (currentTool.equals("Select")) {
            //
        } else if (currentTool.equals("Delete")){
            Command command = commandFactory.getDeleteCommand();
            commandCentral.doCommand(command, new CommandTarget(0, 0, currentShape, activeSelections));
        }
    }

    private void eventClickedAt(double x, double y) {
        if (currentShape == null || currentTool == null) {
            return;
        }



//        Shape shape = prototype.create(currentShape);
//        if (shape == null) {return;}
        if (currentTool.equals("Draw")) {
            Command command = commandFactory.getCreateComand();
            commandCentral.doCommand(command, new CommandTarget(x, y, currentShape, null));
        }

        if (currentTool.equals("Select")) {
            System.out.println("SelectTool selected, selecting much shapes");

            Command command = commandFactory.getSelectComand();
            commandCentral.doCommand(command, new CommandTarget(x, y, currentShape, activeSelections));
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
