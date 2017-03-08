package Factory;

import controllers.MainViewController;
import controllers.SceneController;
import models.DrawModel;
import view.DrawView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * Created by o_0 on 2017-02-17.
 */
public class Setup {

    public static SceneController createConstruct(Supplier<DrawModel> model, Supplier<DrawView> view, ApplyConstructor<DrawModel,DrawView,SceneController> controller) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        return controller.make(model.get(),view.get());
    }

    public static SceneController createMVCSup(Supplier<DrawModel> model, Supplier<DrawView> view, BiFunction<DrawModel,DrawView,SceneController> controller) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //Constructor ctor = controller.getDeclaredConstructor(DrawModel.class, DrawView.class);

//        DrawModel m = (DrawModel)model.newInstance();
//        DrawView v = (DrawView)view.newInstance();
//

        return controller.apply(model.get(),view.get());
    }

    public static SceneController createDrawArea(Class model, Class view,Class controller) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor ctor = controller.getDeclaredConstructor(DrawModel.class, DrawView.class);

//        DrawModel m = (DrawModel)model.newInstance();
//        DrawView v = (DrawView)view.newInstance();
//
        return (SceneController)ctor.newInstance(model.newInstance(),view.newInstance());
    }
    public static SceneController createDrawArea(Class model, Class view) throws IllegalAccessException, InstantiationException {
        DrawModel m = (DrawModel)model.newInstance();
        DrawView v = (DrawView)view.newInstance();
        return (SceneController)new MainViewController(m,v);
    }

}
