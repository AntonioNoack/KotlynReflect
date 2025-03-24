package kotlyn.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

public class FunctionReferenceImpl extends FunctionReference {

    public FunctionReferenceImpl(int arity, Class<Object> owner, String name, String signature, int flags) {
        this(arity, null, owner, name, signature, flags);
    }

    public FunctionReferenceImpl(int arity, Object receiver, Class<Object> owner, String name, String signature, int flags) {
        super(receiver);
        // signature starts with name
        // e.g., writeMatrix3x2d(Lorg/joml/Matrix3x2d)V
        /*try {
            owner.getMethod(name, extractTypeArguments(signature));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }*/
    }

    /*private static final String nativeTypes = "IJFDZBSC";

    private static Class<?>[] extractTypeArguments(String signature) {
        ArrayList<Class<?>> result = new ArrayList<>();
        int i = signature.indexOf('(') + 1;
        while (true) {
            int k = i;
            while (signature.charAt(i) == '[') {
                // skip array symbols
                i++;
            }
            char nextChar = signature.charAt(i++);
            if (nextChar == ')') {
                // reached end :)
                return result.toArray(new Class<?>[0]);
            }
            if (nextChar == 'L') {
                i = signature.indexOf(';', i) + 1;
            } else if (nativeTypes.indexOf(nextChar) < 0) {
                throw new IllegalStateException("Unknown symbol");
            }// else all good
            String fullClassName = signature.substring(k, i);
            try {
                result.add(Class.forName(fullClassName));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }*/

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
