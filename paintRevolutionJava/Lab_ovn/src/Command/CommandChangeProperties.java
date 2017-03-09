package Command;

import models.SPrototype;
import models.SceneModel;
import models.Shape;
import models.ShapeProperties;

/**
 * Created by cj on 2017-03-09.
 */
public class CommandChangeProperties implements Command {

    private Shape shape;
    private SceneModel sceneModel;
    private ShapeProperties shapeProperties;

    public CommandChangeProperties(SceneModel sceneModel, ShapeProperties shapeProperties) {
        this.sceneModel = sceneModel;
        this.shapeProperties = shapeProperties;
    }

    @Override
    public void execute(CommandTarget target) {

        for (Shape s: target.getSelections().getShapes()) {
            s.updateShapeProperties(shapeProperties);
        }

        sceneModel.update();

    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }
}
