package Command;

import models.SPrototype;
import models.SceneModel;
import models.Shape;

import java.util.List;

/**
 * Created by cj on 2017-03-09.
 */
public class ComandDeleteShape implements Command {

    private List<Shape> shapes = null;
    private SceneModel sceneModel;
    private SPrototype prototype;

    public ComandDeleteShape(SceneModel sceneModel, SPrototype prototype) {
        this.sceneModel = sceneModel;
        this.prototype = prototype;
    }

    @Override
    public void execute(CommandTarget target) {

        shapes = target.getSelections().getShapes();
        if (shapes.isEmpty()) {
            return;
        }
        sceneModel.removeShapes(shapes);
    }

    @Override
    public void undo() {
        if (shapes == null) {return;}
        sceneModel.addShapes(shapes);
    }

    @Override
    public void redo() {
        if (shapes == null) {return;}
        sceneModel.removeShapes(shapes);
    }
}
