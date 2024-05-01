package kotlyn.reflect;

import kotlyn.jvm.internal.KClassImpl;

@SuppressWarnings("unused")
public class KClasses {
    public static <V> V safeCast(KClass<V> clazz, Object instance) {
        Class<V> java = ((KClassImpl<V>) clazz).java;
        //noinspection unchecked
        return java.isInstance(instance) ? (V) instance : null;
    }
}
