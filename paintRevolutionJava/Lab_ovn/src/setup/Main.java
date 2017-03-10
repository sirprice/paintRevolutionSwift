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
    private DrawAppFacade drawAppFacade;


    @Override
    public void start(Stage primaryStage) throws Exception{

        drawAppFacade = new DrawAppFacade(primaryStage);
        drawAppFacade.runApp();
//        drawAppFacade.load();;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
