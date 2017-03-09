package models;

import SubjectObserver.MyObservable;
import SubjectObserver.ObserverImpl;
import SubjectObserver.ShapeAdded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cj on 2017-03-08.
 */
public class SPrototype implements MyObservable<ShapeAdded> {

    private Map<String, Shape> shapes;
    private ObserverImpl<ShapeAdded> observer;

    public SPrototype() {
        this.shapes = new HashMap<>();
        this.observer = new ObserverImpl<ShapeAdded>();
    }

    public Shape create(String name){
        return shapes.get(name).createCopy();
    }

    public void add(Shape shape){
        shapes.put(shape.getName(), shape);
        observer.notifyObservers(m -> m.modelChanged());
    }


    public List<ToolDescription> getPrototypes(){
        return new ArrayList<>(shapes.values());
    }

    @Override
    public ObserverImpl<ShapeAdded> getObserver() {
        return observer;
    }
}
