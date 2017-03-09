package setup;

import Factory.CommandFactory;
import Factory.Setup;
import Factory.ShapeFactory;
import StateHandler.CommandState;
import SubjectObserver.MytestObser;
import SubjectObserver.ObserverImpl;
import controllers.*;
import filemanager.FileManager;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.*;
import view.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main extends Application {

    private SceneController controller;
    private ToolBarController toolBarController;
    private CanvasController canvasController;
    private CommandState commandState;
    private MainViewController mainViewController;
    private FileChooser fileChooser;
    private Stage primaryStage;
    private SceneModel sceneModel;



    private static void localFunc(String arg1, int arg2, Dataobj arg3)
    {
        System.out.println("Loc func: " + arg1 + " arg2: " + arg2+ " arg3: " + arg3.toString());
        arg3.x++;
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
//
// Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//        this.controller = Setup.createDrawArea(SceneModel.class,MainView.class);
        // createMVCSup
//        this.controller = Setup.createDrawArea (SceneModel.class,MainView.class, MainViewController.class);
//        this.controller = Setup.createMVCSup(SceneModel::new, MainView::new, (model,view) ->new MainViewController(model,view));
//        this.controller = Setup.createMVCSup(SceneModel::new, MainView::new, MainViewController::new);
//        MainView test = new MainView();

        // ProtoType, ToolBarView , ToolBarController

        // SceneModel, CanvasView , CanvasController

        // MainViewController
        // DrawController, MainView ,ProgramController

        this.primaryStage = primaryStage;

        SPrototype sPrototype = new SPrototype();
        sPrototype.add(ShapeFactory.createCircle());
        sPrototype.add(ShapeFactory.createRectangle());
        sPrototype.add(ShapeFactory.createDude());


        sceneModel = new SceneModel();


        CommandFactory commandFactory = new CommandFactory(sPrototype, sceneModel);
        commandState = new CommandState(commandFactory);

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
        toolBarController = Setup.createConstruct(() -> sPrototype,() -> toolShapesBarView , ToolBarController::new);
        canvasController = Setup.createConstruct(() -> sceneModel,() -> canvasView, CanvasController::new);
        ArrayList<DrawView> toolArea = new ArrayList<>();
        toolArea.add(toolSelectorBarView);
        toolArea.add(toolShapesBarView);

        ArrayList<DrawView> rightToolArea = new ArrayList<>();
        rightToolArea.add(rightToolBar);

        mainViewController = new MainViewController(toolArea,rightToolArea,canvasView);
        //mainViewController = Setup.createConstruct(() -> toolArea, () -> canvasView, MainViewController::new);

//        this.controller = Setup.createConstruct (SceneModel::new, ToolBarView::new, ToolBarController::new);
        mainViewController.showScene(primaryStage);

//        this.controller.showScene(primaryStage);
//        this.controller.drawScene();
        System.out.println("tes test");
        Dataobj data = new Dataobj(5);
        Consumer<MyTest> con = my -> {
            my.func("hej",1,data);
            my.func("hej2",9,data);
            my.func("hej5",5,data);
            my.func("hej4",1,data);
        };
        con.accept(Main::localFunc);

        ObserverImpl<MytestObser> objs = new ObserverImpl<>();
        objs.add(this,this::hej1);
        objs.notifyObservers(myTest -> myTest.doStuff(5,5));
    }


    public void loadFile(String option){
        if (option.equals("Load")){
            sceneModel.setShapes(FileManager.loadFile(primaryStage));
        }
        if (option.equals("Save")){
            FileManager.saveFile(primaryStage, sceneModel.getShapes());
        }
    }


    void hej1(int a,int b) {
        System.out.println("hej1, a:" + a + " b: " + b);
    }

    class Dataobj {
        public int x;

        public Dataobj(int x) {
            this.x = x;
        }

        @Override
        public String toString() {
            return "Dataobj value = " + x;
        }
    }

    public interface MyTest {
        void func(String arg1, int arg2, Dataobj arg3);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
