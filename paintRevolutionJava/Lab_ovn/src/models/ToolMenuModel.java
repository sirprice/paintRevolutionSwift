package models;

import SubjectObserver.MyObservable;
import SubjectObserver.MySubject;
import SubjectObserver.ObserverImpl;
import SubjectObserver.ShapeAdded;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by o_0 on 2017-03-09.
 */
public class ToolMenuModel implements MySubject<ShapeAdded>{
    private ArrayList<ToolDescription> shapes = new ArrayList<>();

    private ObserverImpl<ShapeAdded> observer;

    public ToolMenuModel() {
        this.observer = new ObserverImpl<ShapeAdded>();
        this.shapes.add(() -> "New");
        this.shapes.add(() -> "Load");
        this.shapes.add(() -> "Save");
        this.shapes.add(() -> "Draw");
        this.shapes.add(() -> "Undo");
        this.shapes.add(() -> "Redo");
        this.shapes.add(() -> "Select");
        this.shapes.add(() -> "Delete");
        this.shapes.add(() -> "NewGroup");

    }

    public MyObservable<ShapeAdded> getObserver() {
        return observer;
    }

    public void addShape(Shape newShape) {
        shapes.add(newShape);
        observer.notifyObservers(m -> m.modelChanged());
    }

    public List<ToolDescription> getTools() {
        return this.shapes;

    }
    public void defaultShapes(){
        this.observer = new ObserverImpl<ShapeAdded>();
        this.shapes.add(() -> "Draw");
        this.shapes.add(() -> "Undo");
        this.shapes.add(() -> "Redo");
        this.shapes.add(() -> "Select");
        this.shapes.add(() -> "delete");
        observer.notifyObservers(m -> m.modelChanged());

    }
}
