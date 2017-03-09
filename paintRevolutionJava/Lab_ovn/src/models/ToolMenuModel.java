package models;

import SubjectObserver.ObserverImpl;
import SubjectObserver.ShapeAdded;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by o_0 on 2017-03-09.
 */
public class ToolMenuModel {
    private ArrayList<ToolDescription> shapes = new ArrayList<>();

    private ObserverImpl<ShapeAdded> observer;

    public ToolMenuModel() {
        this.observer = new ObserverImpl<ShapeAdded>();
        this.shapes.add(() -> "Create");
        this.shapes.add(() -> "Select");
        this.shapes.add(() -> "delete");
    }

    public ObserverImpl<ShapeAdded> getObserver() {
        return null;
    }

    public void addShape(Shape newShape) {
        shapes.add(newShape);
        observer.notifyObservers(m -> m.modelChanged());
    }

    public List<ToolDescription> getTools() {
        return this.shapes;

    }
}
