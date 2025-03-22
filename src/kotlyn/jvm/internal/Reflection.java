package kotlyn.jvm.internal;

import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlyn.reflect.*;

import java.util.concurrent.ConcurrentHashMap;

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
    private static final ConcurrentHashMap<Class, Object> classes = new ConcurrentHashMap<>(256);

    @SuppressWarnings("unchecked")
    public static <V> KClass<V> getOrCreateKotlinClass(Class<V> clazz) {
        return (KClassImpl<V>) classes.computeIfAbsent(clazz, KClassImpl::new);
    }
}
