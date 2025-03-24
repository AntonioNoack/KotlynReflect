package kotlyn.jvm.internal;

public class AdaptedFunctionReference {

    public final Object receiver;// must be called this

    public AdaptedFunctionReference(int arity, Class<Object> owner, String name, String signature, int flags) {
        this(arity, null, owner, name, signature, flags);
    }

    public AdaptedFunctionReference(int arity, Object instance, Class<Object> owner, String name, String signature, int flags) {
        receiver = instance;
    }

}
