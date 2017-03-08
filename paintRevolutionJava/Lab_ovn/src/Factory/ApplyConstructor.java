package Factory;

/**
 * Created by o_0 on 2017-02-17.
 */
@FunctionalInterface
public interface ApplyConstructor<T1,T2,R> {
    R make(T1 t1,T2 t2);
}
