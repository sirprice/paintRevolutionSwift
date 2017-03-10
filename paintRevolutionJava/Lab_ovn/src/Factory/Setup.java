package Factory;

import controllers.MainViewController;
import controllers.SceneController;
import models.SceneModel;
import view.DrawView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * Created by o_0 on 2017-02-17.
 */
public class Setup {

    // this glue a model view and controller thogther, Makes it eaiser to build them,
    // instead of ex:
    // Model m = new Model();
    // View v = new View();
    // Controller c = new Controller(m,v);
    // we can do:
    // Setup.createConstruct(Model::new, View::new, Controller::new)
    public static <M,V,C> C createConstruct(Supplier<M> model, Supplier<V> view, ApplyConstructor<M,V,C> controller) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        return controller.make(model.get(),view.get());
    }

}
