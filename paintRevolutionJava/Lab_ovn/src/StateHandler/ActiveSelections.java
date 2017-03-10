package StateHandler;

import models.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cj on 2017-03-09.
 * This class represents all the current selected shapes.
 */
public class ActiveSelections {


    private List<Shape> shapes = new ArrayList<>();

    public ActiveSelections() {
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addShape(Shape shape){
        this.shapes.add(shape);
    }
    public void clearSelections(){
        shapes = new ArrayList<>();
    }
}
