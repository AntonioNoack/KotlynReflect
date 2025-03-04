package kotlyn.reflect.jvm;

import kotlin.reflect.KFunction;
import kotlyn.reflect.impl.KFunctionImpl;

import java.lang.reflect.Method;

@SuppressWarnings("unused")
public class ReflectJvmMapping {
    public static <V> Method getJavaMethod(KFunction<V> function) {
        return ((KFunctionImpl) function).method;
    }
}
