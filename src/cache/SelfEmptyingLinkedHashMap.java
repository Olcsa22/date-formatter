package cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Custom LinkedHashMap to build a quick self-emptying cache mechanism. Linked hash maps are around the same in speed
 * as basic hash maps. Also by extending it, the removeEldestEntry method could be overwritten, so we can prevent our
 * cahce growing too big. By default, that method returns a false, that's why it needs an overwrite.
 * @param <K> key type
 * @param <V> value type
 */
public class SelfEmptyingLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static int MAXIMUM_CACHE_SIZE = 1000;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size()>MAXIMUM_CACHE_SIZE;
    }

}
