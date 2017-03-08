package models;

import SubjectObserver.MyObservable;
import SubjectObserver.ObserverImpl;
import SubjectObserver.ShapeAdded;
import SubjectObserver.ToolSelect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by o_0 on 2017-02-17.
 */
public class SceneModel implements MyObservable<ShapeAdded> {
    private ArrayList<Shape> shapes = new ArrayList<>();

    private ObserverImpl<ShapeAdded> observer;

    public SceneModel() {
            this.observer = new ObserverImpl<ShapeAdded>();
        this.shapes.add(new Circle());
    }

    public ObserverImpl<ShapeAdded> getObserver() {
        return observer;
    }

    public void addShape(Shape newShape) {
        shapes.add(newShape);
        observer.notifyObservers(m -> m.modelChanged());
    }

    public List<Shape> getShapes() {
        return this.shapes;

    }
}
