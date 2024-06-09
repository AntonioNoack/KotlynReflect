package kotlyn.reflect;

import kotlin.jvm.functions.Function2;

public interface KMutableProperty<V> extends KProperty<V> {
    interface Setter extends Function2 {
    }
}
