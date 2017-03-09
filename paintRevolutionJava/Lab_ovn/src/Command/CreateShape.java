package Command;

import models.SPrototype;
import models.SceneModel;
import models.Shape;

import java.lang.annotation.Target;

/**
 * Created by o_0 on 2017-03-09.
 */
public class CreateShape extends Command {

    private Shape shape;
    private SceneModel sceneModel;
    private SPrototype prototype;

    public CreateShape(SceneModel sceneModel, SPrototype prototype) {
        this.sceneModel = sceneModel;
        this.prototype = prototype;
    }

    @Override
    public void execute(CommandTarget target) {
        Shape newShape = prototype.create(target.getName());
        newShape.setX(target.getX());
        newShape.setY(target.getY());
        this.shape = newShape;
        System.out.println("CreateShape: execute");
        sceneModel.addShape(shape);
    }

    @Override
    public void undo() {
        System.out.println("CreateShape: undo");
        sceneModel.removeShape(this.shape);
    }

    @Override
    public void redo() {
        System.out.println("CreateShape: redo");
        sceneModel.addShape(this.shape);
    }
}
