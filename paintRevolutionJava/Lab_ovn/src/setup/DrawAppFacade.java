package setup;

import Factory.CommandFactory;
import Factory.Setup;
import Factory.ShapeFactory;
import StateHandler.CommandState;
import controllers.CanvasController;
import controllers.MainViewController;
import controllers.ToolBarController;
import controllers.ToolMenuController;
import filemanager.FileManager;
import javafx.stage.Stage;
import models.SPrototype;
import models.SceneModel;
import models.ToolMenuModel;
import view.CanvasView;
import view.DetailView;
import view.DrawView;
import view.ToolBarView;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Simple facade to hide the complex start up of the system, and to provide a clean way of controlling it
 */
public class DrawAppFacade {
    private Stage primaryStage;
    private SceneModel sceneModel;
    private MainViewController mainViewController;
//    private SPrototype sPrototype
    public DrawAppFacade(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;

        SPrototype sPrototype = new SPrototype();
        sPrototype.add(ShapeFactory.createCircle());
        sPrototype.add(ShapeFactory.createRectangle());
        sPrototype.add(ShapeFactory.createDude());

        sceneModel = new SceneModel();

        CommandFactory commandFactory = new CommandFactory(sPrototype, sceneModel);
        CommandState commandState = new CommandState(commandFactory);

        ToolBarView toolShapesBarView = new ToolBarView();
        ToolBarView toolSelectorBarView = new ToolBarView();
        CanvasView canvasView = new CanvasView();
        DetailView rightToolBar = new DetailView();

        commandState.setCanvasClickObserver(canvasView);
        commandState.setShapeSelectObserver(toolShapesBarView);
        commandState.setToolSelectionObserver(toolSelectorBarView);
        commandState.setShapePropertyObserver(rightToolBar);

        toolSelectorBarView.getObserver().add(this,this::loadFile);

        ToolMenuController controller = Setup.createConstruct(ToolMenuModel::new , () -> toolSelectorBarView, ToolMenuController::new);
        ToolBarController toolBarController = Setup.createConstruct(() -> sPrototype,() -> toolShapesBarView , ToolBarController::new);
        CanvasController canvasController = Setup.createConstruct(() -> sceneModel,() -> canvasView, CanvasController::new);

        ArrayList<DrawView> toolArea = new ArrayList<>();
        toolArea.add(toolSelectorBarView);
        toolArea.add(toolShapesBarView);

        ArrayList<DrawView> rightToolArea = new ArrayList<>();
        rightToolArea.add(rightToolBar);

        mainViewController = new MainViewController(toolArea,rightToolArea,canvasView);
    }

    public void runApp() {
        mainViewController.showScene(primaryStage);
    }

    public void load() {
        loadFile("Load");
    }

    public void save() {
        loadFile("Save");
    }

    private void loadFile(String option){
        if (option.equals("Load")){
            sceneModel.setShapes(FileManager.loadFile(primaryStage));
        }
        if (option.equals("Save")){
            FileManager.saveFile(primaryStage, sceneModel.getShapes());
        }
    }
}
