package SubjectObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by o_0 on 2017-03-08.
 */
public class ObserverImpl <Observer> {
    Map<Object,Observer> observers = new HashMap<>();

    public ObserverImpl() {
    }

    public void add(Object observer, Observer method) {
        observers.put(observer,method);
    }

    public void remove(Object observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Consumer<Observer> subject) {
        for ( Map.Entry<Object, Observer> entry  : observers.entrySet()) {
            subject.accept(entry.getValue());
        }
    }
}
