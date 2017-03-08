package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by o_0 on 2017-02-17.
 */
public class SceneModel {
    private ArrayList<Shape> shapes = new ArrayList<>();

    public SceneModel() {

        this.shapes.add(new Circle());
    }

    public List<Shape> getShapes() {
        return this.shapes;

    }
}
