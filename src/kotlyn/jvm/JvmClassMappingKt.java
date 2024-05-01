package kotlyn.jvm;

import kotlyn.jvm.internal.KClassImpl;
import kotlyn.reflect.KClass;

@SuppressWarnings("unused")
public class JvmClassMappingKt {
    public static <V> Class<V> getJavaClass(KClass<V> clazz) {
        return ((KClassImpl<V>) clazz).java;
    }
}
