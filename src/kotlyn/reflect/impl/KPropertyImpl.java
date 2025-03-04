package kotlyn.reflect.impl;

import kotlyn.reflect.KMutableProperty1;
import kotlyn.reflect.KProperty1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class KPropertyImpl<T, V> implements KProperty1<T, V>, KMutableProperty1<T, V> {
    private final Field field;

    public KPropertyImpl(Field field) {
        this.field = field;
    }

    @Override
    public String getName() {
        return field.getName();
    }

    @Override
    public void setAccessible(boolean value) {
        field.setAccessible(value);
    }

    @Override
    public List<Annotation> getAnnotations() {
        return Arrays.asList(field.getAnnotations());
    }
}