package SubjectObserver;

/**
 * Created by o_0 on 2017-03-08.
 */
public interface MySubject<T> {
    MyObservable<T> getObserver();
}
