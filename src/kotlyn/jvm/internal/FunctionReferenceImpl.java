package kotlyn.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

public class FunctionReferenceImpl extends FunctionReference {

    public FunctionReferenceImpl(int arity, Class<Object> owner, String name, String signature, int flags) {

    }

    public FunctionReferenceImpl(int arity, Object instance, Class<Object> owner, String name, String signature, int flags) {
        this(arity, owner, name, signature, flags);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void setAccessible(boolean value) {
    }

    @Override
    public List<Annotation> getAnnotations() {
        return Collections.emptyList();
    }
}
