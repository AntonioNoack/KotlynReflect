package kotlyn.jvm.internal;

import kotlyn.reflect.KProperty1;

@SuppressWarnings({"unused", "rawtypes"})
public class PropertyReference1Impl<K, V>
        extends PropertyReference0Impl<K, V>
        implements KProperty1<K, V> {
    public PropertyReference1Impl(Class clazz, String propertyName, String getterName, int idk) {
        super(clazz, propertyName, getterName, idk);
    }
}
