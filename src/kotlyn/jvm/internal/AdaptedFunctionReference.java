package kotlyn.jvm.internal;

public class AdaptedFunctionReference {

    public AdaptedFunctionReference(int arity, Class<Object> owner, String name, String signature, int flags) {

    }

    public AdaptedFunctionReference(int arity, Object instance, Class<Object> owner, String name, String signature, int flags) {
        this(arity, owner, name, signature, flags);
    }

}
