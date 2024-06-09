package kotlyn.jvm.internal;

import kotlin.jvm.functions.Function1;
import kotlyn.reflect.KProperty1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"unused", "rawtypes"})
public class PropertyReference0Impl<K, V>
        implements KProperty1<K, V>, Function1<K, V> {

    Object instance;
    Class clazz;
    String propertyName;
    String getterName;
    Field field;
    Method getter;

    public PropertyReference0Impl(Class clazz, String propertyName, String getterName, int idk) {
        this.clazz = clazz;
        this.propertyName = propertyName;
        this.getterName = getterName;
    }

    public PropertyReference0Impl(Object instance, Class clazz, String propertyName, String getterName, int idk) {
        this(clazz, propertyName, getterName, idk);
        this.instance = instance;
    }

    private void ensureField() {
        try {
            if (field == null) field = clazz.getField(propertyName);
        } catch (NoSuchFieldException e) {
            System.err.println("NoSuchField: " + clazz + ", " + propertyName + ", " + getterName);
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private void ensureGetter() {
        try {
            if (getter == null) getter = clazz.getMethod(getterName.substring(0, getterName.indexOf('(')));
        } catch (NoSuchMethodException e) {
            System.err.println("NoSuchMethod: " + clazz + ", " + propertyName + ", " + getterName);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getName() {
        return propertyName;
    }

    @Override
    public void setAccessible(boolean value) {
        ensureField();
        field.setAccessible(value);
    }

    @Override
    public List<Annotation> getAnnotations() {
        ensureField();
        return Arrays.asList(field.getAnnotations());
    }

    @Override
    @SuppressWarnings("unchecked")
    public V invoke(K k) {
        ensureGetter();
        try {
            return (V) getter.invoke(k);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
