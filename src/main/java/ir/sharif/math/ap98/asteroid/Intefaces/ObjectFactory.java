package ir.sharif.math.ap98.asteroid.Intefaces;

public interface ObjectFactory<T> {

    /**
     * Returns a new instance of an object type T.
     *
     * @return T an new instance of the object type T
     */
    public abstract T createNew();
}
