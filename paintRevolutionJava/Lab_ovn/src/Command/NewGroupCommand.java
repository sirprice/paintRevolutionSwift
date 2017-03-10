package Command;

import models.SPrototype;
import models.SceneModel;
import models.Shape;
import models.ShapeGroup;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by o_0 on 2017-03-10.
 */
public class NewGroupCommand implements IrreversibleCommand {

    private SceneModel sceneModel;
    private SPrototype prototype;

    public NewGroupCommand(SceneModel sceneModel, SPrototype prototype) {
        this.sceneModel = sceneModel;
        this.prototype = prototype;
    }

    static int groupCount = 1;

    @Override
    public void execute(CommandTarget target) {
        List<Shape> shapes = target.getSelections().getShapes();
        if (shapes.isEmpty()) {
            return;
        }
        ArrayList<Shape> newShapes = new ArrayList<>();
        for (Shape s : shapes) {
            newShapes.add(s.createCopy());
        }
        ShapeGroup shapeGroup = new ShapeGroup(0, 0, newShapes, "group" + groupCount);

        groupCount++;
        prototype.add(shapeGroup);


    }
}
