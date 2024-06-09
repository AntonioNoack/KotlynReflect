package kotlyn.jvm.internal;

import kotlyn.reflect.KMutableProperty0;

@SuppressWarnings({"unused", "rawtypes"}) // used by Kotlin-compiled classes (ActionManager)
public class MutablePropertyReference0Impl
        extends PropertyReference0Impl
        implements KMutableProperty0, MutablePropertyReference0 {
    public MutablePropertyReference0Impl(Class clazz, String propertyName, String getterName, int idk) {
        super(clazz, propertyName, getterName, idk);
    }
    public MutablePropertyReference0Impl(Object instance, Class clazz, String propertyName, String getterName, int idk) {
        super(instance, clazz, propertyName, getterName, idk);
    }
}
