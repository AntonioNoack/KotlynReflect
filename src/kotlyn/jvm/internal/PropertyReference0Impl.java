package kotlyn.jvm.internal;

import kotlin.jvm.functions.Function1;
import kotlyn.reflect.KProperty1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unused"})
public class PropertyReference0Impl<K, V>
        implements KProperty1<K, V>, Function1<K, V> {

    final Object instance;
    final Field field;
    final Method getter;

    public PropertyReference0Impl(Class<?> clazz, String propertyName, String getterName, int idk) {
        this(null, clazz, propertyName, getterName, idk);
    }

    public PropertyReference0Impl(Object instance, Class<?> clazz, String propertyName, String getterName, int idk) {
        field = findField(clazz, propertyName);
        getter = findGetter(clazz, getterName);
        if (field == null) warnNoField(clazz, propertyName, getterName);
        else if (getter != null) warnNoMethod(clazz, propertyName, getterName);
        this.instance = instance;
    }

    private static Field findField(Class<?> clazz, String propertyName) {
        try {
            return clazz.getField(propertyName);
        } catch (NoSuchFieldException ignored) {
            return null;
        }
    }

    private static Method findGetter(Class<?> clazz, String getterName) {
        try {
            return clazz.getMethod(getterName.substring(0, getterName.indexOf('(')));
        } catch (NoSuchMethodException ignored) {
            return null;
        }
    }

    private static void warnNoField(Class<?> clazz, String propertyName, String getterName) {
        warn("NoSuchField: ", clazz, propertyName, getterName);
    }

    private static void warnNoMethod(Class<?> clazz, String propertyName, String getterName) {
        warn("NoSuchMethod: ", clazz, propertyName, getterName);
    }

    private static void warn(String message, Class<?> clazz, String propertyName, String getterName) {
        System.err.println(message + clazz + ", " + propertyName + ", " + getterName);
    }

    @Override
    public String getName() {
        return field != null ? field.getName() : null;
    }

    @Override
    public void setAccessible(boolean value) {
        if (field != null) field.setAccessible(value);
        if (getter != null) getter.setAccessible(value);
    }

    @Override
    public List<Annotation> getAnnotations() {
        return field != null ? Arrays.asList(field.getAnnotations()) : Collections.emptyList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public V invoke(K k) {
        try {
            if (getter != null) return (V) getter.invoke(k);
            if (field != null) return (V) field.get(k);
        } catch (IllegalAccessException | InvocationTargetException ignored) {
        }
        return null;
    }
}
