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
    private List<Shape> shapes = new ArrayList<>();

    private ObserverImpl<ShapeAdded> observer;

    public SceneModel() {
            this.observer = new ObserverImpl<ShapeAdded>();
        this.shapes.add(new Circle());
    }

    public ObserverImpl<ShapeAdded> getObserver() {
        return observer;
    }

    public void addShape(Shape newShape) {

        System.out.println("SceneModel: addShape size:  " + shapes.size());
        shapes.add(newShape);
        observer.notifyObservers(m -> m.modelChanged());
    }

    public boolean removeShape(Shape shape) {
        System.out.println("SceneModel:removeShape size:  " + shapes.size());

        if (shapes.remove(shape)) {
            observer.notifyObservers(m -> m.modelChanged());
            return true;
        }
        System.out.println("SceneModel:removeShape false:  " + shapes.size());

        return false;
    }

    public List<Shape> getShapes() {
        return this.shapes;

    }
    public Shape getShapeAt(double x, double y){
        for (Shape s: shapes){
            if (s.containsPoint(x,y))
                return s;
        }
        return null;
    }


    public void setShapes(List<Shape> shapes){
        if (shapes != null){
            this.shapes = shapes;
            update();
        }
    }

    public void totalAnnihilation(){
        shapes = new ArrayList<>();
        observer.notifyObservers(m -> m.modelChanged());

    }

    public void update(){
        observer.notifyObservers(m -> m.modelChanged());
    }
}
