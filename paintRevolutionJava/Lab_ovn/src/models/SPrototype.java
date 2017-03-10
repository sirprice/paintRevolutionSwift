package models;

import SubjectObserver.MyObservable;
import SubjectObserver.MySubject;
import SubjectObserver.ObserverImpl;
import SubjectObserver.ShapeAdded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cj on 2017-03-08.
 */
public class SPrototype implements MySubject<ShapeAdded> {

    private Map<String, Shape> shapes;
    private ObserverImpl<ShapeAdded> observer;

    public SPrototype() {
        this.shapes = new HashMap<>();
        this.observer = new ObserverImpl<ShapeAdded>();
    }

    public Shape create(String name){
        try {
            return shapes.get(name).clone();
        }catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    public void add(Shape shape){
        if (shape == null) {return;}
        shapes.put(shape.getName(), shape);
        observer.notifyObservers(m -> m.modelChanged());
    }


    public List<ToolDescription> getPrototypes(){
        return new ArrayList<>(shapes.values());
    }

    @Override
    public MyObservable<ShapeAdded> getObserver() {
        return observer;
    }
}
