package kotlyn.jvm.internal;

import kotlyn.reflect.KMutableProperty1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"unused", "rawtypes"}) // used by Kotlin-compiled classes
public class MutablePropertyReference1Impl implements KMutableProperty1, MutablePropertyReference1 {
    Class clazz;
    String propertyName;
    String getterName;
    Field field;

    public MutablePropertyReference1Impl(Class clazz, String propertyName, String getterName, int idk) {
        this.clazz = clazz;
        this.propertyName = propertyName;
        this.getterName = getterName;
    }

    @Override
    public void setAccessible(boolean value) {
        try {
            if (field == null) field = clazz.getField(propertyName);
            field.setAccessible(value);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Annotation> getAnnotations() {
        try {
            if (field == null) field = clazz.getField(propertyName);
            return Arrays.asList(field.getAnnotations());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
