package setup;

import Factory.Setup;
import SubjectObserver.MytestObser;
import SubjectObserver.ObserverImpl;
import controllers.MainViewController;
import controllers.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;
import models.SceneModel;
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
//        this.controller = Setup.createDrawArea(SceneModel.class,MainView.class);
        // createMVCSup
//        this.controller = Setup.createDrawArea (SceneModel.class,MainView.class, MainViewController.class);
//        this.controller = Setup.createMVCSup(SceneModel::new, MainView::new, (model,view) ->new MainViewController(model,view));
//        this.controller = Setup.createMVCSup(SceneModel::new, MainView::new, MainViewController::new);
        MainView test = new MainView();
        this.controller = Setup.createConstruct (SceneModel::new, () -> test, MainViewController::new);
        this.controller.showScene(primaryStage);
        this.controller.drawScene();
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
