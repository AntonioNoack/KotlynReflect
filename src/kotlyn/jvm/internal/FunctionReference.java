package kotlyn.jvm.internal;

import kotlyn.reflect.KFunction;

public abstract class FunctionReference extends CallableReference implements KFunction {
    public FunctionReference(Object receiver) {
        super(receiver);
    }
}
