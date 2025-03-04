package kotlyn.reflect.full;

import kotlyn.jvm.internal.KClassImpl;
import kotlyn.jvm.internal.Reflection;
import kotlyn.reflect.*;
import kotlyn.reflect.impl.KFunctionImpl;
import kotlyn.reflect.impl.KPropertyImpl;

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

    // used for getting DebugActions
    public static Collection<KFunction> getMemberFunctions(KClass clazz) {
        Class java = ((KClassImpl) clazz).java;
        Method[] methods = java.getMethods();
        ArrayList<KFunction> result = new ArrayList<>(methods.length);
        for (Method method : methods) {
            result.add(new KFunctionImpl(method));
        }
        return result;
    }
}
