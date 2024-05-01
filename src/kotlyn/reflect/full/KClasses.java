package kotlyn.reflect.full;

import kotlyn.jvm.internal.KClassImpl;
import kotlyn.jvm.internal.Reflection;
import kotlyn.reflect.KClass;
import kotlyn.reflect.KFunction;
import kotlyn.reflect.KMutableProperty1;
import kotlyn.reflect.KProperty1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class KClasses {
    public static List<KClass> getSuperclasses(KClass clazz0) {
        KClassImpl clazz = (KClassImpl) clazz0;
        Class java = clazz.java;
        Class superClazz = java.getSuperclass();
        return superClazz == null ? Collections.emptyList() :
                Collections.singletonList(Reflection.getOrCreateKotlinClass(superClazz));
    }

    public static Collection<KProperty1> getDeclaredMemberProperties(KClass clazz) {
        Class java = ((KClassImpl) clazz).java;
        return wrapFields(java.getDeclaredFields());
    }

    public static Collection<KProperty1> getMemberProperties(KClass clazz) {
        Class java = ((KClassImpl) clazz).java;
        return wrapFields(java.getFields());
    }

    private static Collection<KProperty1> wrapFields(Field[] fields) {
        ArrayList<KProperty1> result = new ArrayList<>(fields.length);
        for (Field field : fields) {
            result.add(new KPropertyImpl(field));
        }
        return result;
    }

    private static class KPropertyImpl implements KProperty1, KMutableProperty1 {
        private final Field field;

        private KPropertyImpl(Field field) {
            this.field = field;
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

    // used for getting DebugActions
    public static Collection<KFunction> getMemberFunctions(KClass clazz) {
        Class java = ((KClassImpl) clazz).java;
        Method[] methods = java.getMethods();
        ArrayList<KFunction> result = new ArrayList<>(methods.length);
        for (Method method : methods) {
            result.add(new KFunction() {
                @Override
                public void setAccessible(boolean value) {
                    method.setAccessible(value);
                }

                @Override
                public List<Annotation> getAnnotations() {
                    return Arrays.asList(method.getAnnotations());
                }
            });
        }
        return result;
    }
}
