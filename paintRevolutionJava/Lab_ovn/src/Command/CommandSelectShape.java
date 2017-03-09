package Command;

import models.SPrototype;
import models.SceneModel;
import models.Shape;

/**
 * Created by cj on 2017-03-09.
 */
public class CommandSelectShape implements Command {

    private Shape shape;
    private SceneModel sceneModel;
    private SPrototype prototype;

    public CommandSelectShape(SceneModel sceneModel, SPrototype prototype) {
        this.sceneModel = sceneModel;
        this.prototype = prototype;
    }

    @Override
    public void execute(CommandTarget target) {
        Shape s = sceneModel.getShapeAt(target.getX(),target.getY());
        if (s == null){
            target.getSelections().clearSelections();
            return;
        }

        shape = s;
        target.getSelections().addShape(shape);



    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }
}
