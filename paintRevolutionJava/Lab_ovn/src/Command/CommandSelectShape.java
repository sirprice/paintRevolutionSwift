package Command;

import javafx.scene.paint.Color;
import models.SPrototype;
import models.SceneModel;
import models.Shape;
import models.ShapeProperties;

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
//            for(Shape tmp : target.getSelections().getShapes()) {
//                tmp.updateShapeProperties(new ShapeProperties(Color.BLACK,false,tmp.getShapeProperties().getLineWidth()));
//            }
            target.getSelections().clearSelections();
            sceneModel.update();
            return;
        }

        shape = s;
        //s.updateShapeProperties(new ShapeProperties(Color.BLUE,false,s.getShapeProperties().getLineWidth()));
        target.getSelections().addShape(shape);
        //sceneModel.update();


    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }
}
