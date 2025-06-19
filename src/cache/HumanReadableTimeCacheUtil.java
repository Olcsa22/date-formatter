package cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class HumanReadableTimeCacheUtil {


    private static Map<Integer, String> resultCache = new SelfEmptyingLinkedHashMap<>();

    public static void cache(int input, String result) {
        resultCache.put(input, result);
    }

    public static String findInCache(int input) {
        return resultCache.get(input);
    }
}
