package kotlyn.reflect.impl;

import kotlyn.reflect.KFunction;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class KFunctionImpl<V> implements KFunction<V> {
    public final Method method;

    public KFunctionImpl(Method method) {
        this.method = method;
    }

    @Override
    public String getName() {
        return method.getName();
    }

    @Override
    public void setAccessible(boolean value) {
        method.setAccessible(value);
    }

    @Override
    public List<Annotation> getAnnotations() {
        return Arrays.asList(method.getAnnotations());
    }
}
