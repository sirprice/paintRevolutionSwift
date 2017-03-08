package setup;

import Factory.Setup;
import controllers.MainViewController;
import controllers.SceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.DrawModel;
import view.MainView;

import java.util.function.Consumer;

public class Main extends Application {

    SceneController controller;
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
//        this.controller = Setup.createDrawArea(DrawModel.class,MainView.class);
        // createMVCSup
//        this.controller = Setup.createDrawArea (DrawModel.class,MainView.class, MainViewController.class);
//        this.controller = Setup.createMVCSup(DrawModel::new, MainView::new, (model,view) ->new MainViewController(model,view));
//        this.controller = Setup.createMVCSup(DrawModel::new, MainView::new, MainViewController::new);
        this.controller = Setup.createConstruct (DrawModel::new, MainView::new, MainViewController::new);
        this.controller.showScene(primaryStage);
        System.out.println("tes test");
        Dataobj data = new Dataobj(5);
        Consumer<MyTest> con = my -> {
            my.func("hej",1,data);
            my.func("hej2",9,data);
            my.func("hej5",5,data);
            my.func("hej4",1,data);
        };
        con.accept(Main::localFunc);
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
