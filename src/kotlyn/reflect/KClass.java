package kotlyn.reflect;

public interface KClass<V> {
    String getSimpleName();
    String getQualifiedName();
    boolean isInstance(Object instance);
}
