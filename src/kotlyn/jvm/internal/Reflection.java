package kotlyn.jvm.internal;

import kotlyn.reflect.KClass;
import kotlyn.reflect.KMutableProperty0;
import kotlyn.reflect.KMutableProperty1;

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

    @SuppressWarnings("rawtypes")
    private static final ConcurrentHashMap<Class, Object> classes = new ConcurrentHashMap<>(256);

    @SuppressWarnings("unchecked")
    public static <V> KClass<V> getOrCreateKotlinClass(Class<V> clazz) {
        return (KClassImpl<V>) classes.computeIfAbsent(clazz, KClassImpl::new);
    }
}
