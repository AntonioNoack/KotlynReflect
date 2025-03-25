package kotlyn.jvm.internal;

import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlyn.reflect.*;

import java.util.HashMap;

public class Reflection {
    @SuppressWarnings({"rawtypes", "unused"}) // used by some classes
    public static KMutableProperty0 mutableProperty0(MutablePropertyReference0 ref) {
        return (KMutableProperty0) ref;
    }

    @SuppressWarnings({"rawtypes", "unused"}) // used by some classes
    public static KMutableProperty1 mutableProperty1(MutablePropertyReference1 ref) {
        return (KMutableProperty1) ref;
    }

    @SuppressWarnings({"rawtypes", "unused"}) // not used yet, because it's trivial?
    public static KProperty0 property0(PropertyReference0 ref) {
        return (KProperty0) ref;
    }

    @SuppressWarnings({"rawtypes", "unused"}) // used by ScrollPanelXY-Companion
    public static KProperty1 property1(PropertyReference1 ref) {
        return (KProperty1) ref;
    }

    @SuppressWarnings("rawtypes")
    private static final HashMap<Class, KClass<?>> classes = new HashMap<>(256);

    public static <V> KClass<?> getOrCreateKotlinClass(Class<V> javaClass) {
        synchronized (classes) {
            KClass<?> kotlinClass = classes.get(javaClass);
            if (kotlinClass != null) return kotlinClass;
            kotlinClass = new KClassImpl<>(javaClass);
            classes.put(javaClass, kotlinClass);
            return kotlinClass;
        }
    }
}
