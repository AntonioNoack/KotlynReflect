package kotlyn.jvm.internal;

import kotlyn.reflect.KClass;

public class KClassImpl<V> implements KClass<V> {
    public final Class<V> java;

    public KClassImpl(Class<V> java) {
        this.java = java;
    }

    @Override
    public String getSimpleName() {
        return java.getSimpleName();
    }

    @Override
    public boolean isInstance(Object instance) {
        return java.isInstance(instance);
    }
}
