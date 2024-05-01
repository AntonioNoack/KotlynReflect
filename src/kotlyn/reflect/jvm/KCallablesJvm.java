package kotlyn.reflect.jvm;

import kotlyn.reflect.KCallable;

@SuppressWarnings("unused")
public class KCallablesJvm {
    public static <V> void setAccessible(KCallable<V> callable, boolean value) {
        callable.setAccessible(value);
    }
}
