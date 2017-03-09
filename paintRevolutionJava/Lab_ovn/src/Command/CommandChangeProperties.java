package Command;

import models.SPrototype;
import models.SceneModel;
import models.Shape;
import models.ShapeProperties;

import java.util.List;

/**
 * Created by cj on 2017-03-09.
 */
public class CommandChangeProperties implements Command {

    private Shape shape;
    private List<Shape> oldShapeList;
    private List<Shape> newShapeList;
    private SceneModel sceneModel;
    private ShapeProperties shapeProperties;
    private List<ShapeProperties> oldShapePropertiesList;

    public CommandChangeProperties(SceneModel sceneModel, ShapeProperties shapeProperties) {
        this.sceneModel = sceneModel;
        this.shapeProperties = shapeProperties;
    }

    @Override
    public void execute(CommandTarget target) {


        for (Shape s: target.getSelections().getShapes()) {
            oldShapeList.add(s);
            oldShapePropertiesList.add(s.getShapeProperties());

            s.updateShapeProperties(shapeProperties);
            newShapeList.add(s);
        }

        sceneModel.update();

    }

    @Override
    public void undo() {
        for (int i=0;i<oldShapeList.size();i++){

        }
    }

    @Override
    public void redo() {

    }
}
