package StateHandler;

import Command.Command;
import Command.CommandCentral;
import Command.CommandTarget;
import Command.IrreversibleCommand;
import Factory.CommandFactory;
import SubjectObserver.CanvasClick;
import SubjectObserver.MySubject;
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
    private CommandCentral commandCentral = new CommandCentral();
    private CommandFactory commandFactory;


    public CommandState(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void setToolSelectionObserver(MySubject<ToolSelect> selectObserver) {

    /**
     * adding observer to the selectObserver and connecting it to function to handle event
     * @param selectObserver
     */
    public void setToolSelectionObserver(MyObservable<ToolSelect> selectObserver) {
        selectObserver.getObserver().add(this, this::eventSelectTool);
    }

    public void setShapePropertyObserver(MySubject<ObserverShapeProperties> selectObserver) {
    /**
     * adding observer to the selectObserver and connecting it to function to handle event
     * @param selectObserver
     */
    public void setShapePropertyObserver(MyObservable<ObserverShapeProperties> selectObserver) {
        selectObserver.getObserver().add(this, this::eventShapePropertiesChanged);
    }


    public void setShapeSelectObserver(MySubject<ToolSelect> selectObserver) {
    /**
     * adding observer to the selectObserver and connecting it to function to handle event
     * @param selectObserver
     */
    public void setShapeSelectObserver(MyObservable<ToolSelect> selectObserver) {
        selectObserver.getObserver().add(this, this::eventSelectShapeTool);
    }

    public void setCanvasClickObserver(MySubject<CanvasClick> canvasClickObserver) {
    /**
     * adding observer to the selectObserver and connecting it to function to handle event
     * @param canvasClickObserver
     */
    public void setCanvasClickObserver(MyObservable<CanvasClick> canvasClickObserver) {
        canvasClickObserver.getObserver().add(this, this::eventClickedAt);
    }


    /**
     * handles the event of when user edits the properties of the shapes
     * @param color
     * @param isFilled
     * @param lineWidth
     */
    private void eventShapePropertiesChanged(Color color, boolean isFilled, double lineWidth){
        Command command = commandFactory.getChangePropertiesCommand(new ShapeProperties(color,isFilled,lineWidth));
        commandCentral.doCommand(command, new CommandTarget(0, 0, currentShape, activeSelections));

    }

    /**
     * handles the events of mouse click on the toolbar
     * @param name
     */
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
        }else if (currentTool.equals("NewGroup")){
            IrreversibleCommand command = commandFactory.getNewGroupCommand();
            command.execute(new CommandTarget(0, 0, currentShape, activeSelections));
        }
    }


    /**
     * Handles the event when a mouse click happens on the canvas draw area
     * @param x
     * @param y
     */
    private void eventClickedAt(double x, double y) {
        if (currentShape == null || currentTool == null) {
            return;
        }

        if (currentTool.equals("Draw")) {
            Command command = commandFactory.getCreateComand();
            commandCentral.doCommand(command, new CommandTarget(x, y, currentShape, null));
        }

        if (currentTool.equals("Select")) {
            Command command = commandFactory.getSelectComand();
            commandCentral.doCommand(command, new CommandTarget(x, y, currentShape, activeSelections));
        }

    }

    /**
     * handles the event when selecting a shape tool
     * @param name
     */
    private void eventSelectShapeTool(String name) {
        currentShape = name;
    }

}
