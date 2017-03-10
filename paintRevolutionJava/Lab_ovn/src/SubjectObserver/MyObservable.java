package SubjectObserver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Observerble interface,
 */
public interface MyObservable<Observer> {

    void add(Object observer, Observer method);

    void remove(Object observer);

    void notifyObservers(Consumer<Observer> subject);
}
