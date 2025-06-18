package util;

import java.util.HashMap;
import java.util.Map;

public class HumanReadableTimeCacheUtil {

    private static Map<Integer, String> resultCache = new HashMap<>();

    public static void cache(int input, String result) {
        if(!resultCache.containsKey(input)){
            resultCache.put(input, result);
        }
    }

    public static String findInCache(int input) {
        return resultCache.get(input);
    }
}
