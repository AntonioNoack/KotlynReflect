package kotlyn.reflect;

public interface KClass<V> {
    String getSimpleName();
    boolean isInstance(Object instance);
}
