package kotlyn.reflect;

import java.lang.annotation.Annotation;
import java.util.List;

public interface KCallable<V> {
    String getName();
    void setAccessible(boolean value);
    List<Annotation> getAnnotations();
}
