package setup;

import Factory.Setup;
import Factory.ShapeFactory;
import StateHandler.CommandState;
import SubjectObserver.MytestObser;
import SubjectObserver.ObserverImpl;
import controllers.CanvasController;
import controllers.MainViewController;
import controllers.SceneController;
import controllers.ToolBarController;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import models.*;
import view.CanvasView;
import view.MainView;
import view.ToolBarView;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Main extends Application {

    SceneController controller;
    ToolBarController toolBarController;
    CanvasController canvasController;
    CommandState commandState;
    MainViewController mainViewController;
    private static void localFunc(String arg1, int arg2, Dataobj arg3)
    {
        System.out.println("Loc func: " + arg1 + " arg2: " + arg2+ " arg3: " + arg3.toString());
        arg3.x++;
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
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


        SPrototype sPrototype = new SPrototype();
        sPrototype.add(ShapeFactory.createCircle());
        sPrototype.add(ShapeFactory.createRectangle());
        sPrototype.add(ShapeFactory.createDude());

        SceneModel sceneModel = new SceneModel();

        commandState = new CommandState(sPrototype, sceneModel);

        ToolBarView toolBarView = new ToolBarView();
        CanvasView canvasView = new CanvasView();

        commandState.setCanvasClickObserver(canvasView);
        commandState.setSelectObserver(toolBarView);

        toolBarController = Setup.createConstruct(() -> sPrototype,() -> toolBarView , ToolBarController::new);
        canvasController = Setup.createConstruct(() -> sceneModel,() -> canvasView, CanvasController::new);

        mainViewController = Setup.createConstruct(() -> toolBarView, () -> canvasView, MainViewController::new);

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
