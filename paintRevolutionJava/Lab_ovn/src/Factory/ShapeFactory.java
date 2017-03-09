package Factory;

import models.Circle;
import models.Rectangle;
import models.Shape;
import models.ShapeGroup;

import java.util.ArrayList;

/**
 * Created by o_0 on 2017-03-09.
 */
public class ShapeFactory {
    private ShapeFactory(){}
    public static ShapeGroup createDude() {
        ArrayList<Shape> dudeComp = new ArrayList<>();
        dudeComp.add(new Circle(0.0, -60.0,  40.0));
        dudeComp.add(new Rectangle(-50.0, -20.0, 80.0,  20));
        dudeComp.add(new Rectangle(50.0, -20.0, 80.0,  20));
        dudeComp.add(new Rectangle(0.0, 0.0, 20.0,  80));
        dudeComp.add(new Rectangle(-20.0, 60.0, 20.0,  50));
        dudeComp.add(new Rectangle(20.0, 60.0, 20.0,  50));

        ShapeGroup shapeGroup = new ShapeGroup(0, 0, dudeComp);
        shapeGroup.setName("dude");
        return shapeGroup;
    }

    public static Circle createCircle() {
        return new Circle();
    }

    public static Rectangle createRectangle() {
        return new Rectangle();
    }
}
