public abstract class CrudOperations<T> {
    public abstract void create(T item);
    public abstract T read(String identifier);
    public abstract void update(T item);
    public abstract void delete(String identifier);
}
