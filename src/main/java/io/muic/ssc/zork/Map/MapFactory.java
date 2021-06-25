package io.muic.ssc.zork.Map;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class MapFactory {

    private static final java.util.Map<String, Map> AVAILABLE_MAP = new HashMap<>() {{
        MapType[] mapTypes = MapType.values();
        for (int i = 0; i < mapTypes.length; i++) {
            try {
                Map map = mapTypes[i].getMapClass().getDeclaredConstructor().newInstance();
                put(mapTypes[i].getMapName(), map);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }};

    public static Map get(String map) {
        if (AVAILABLE_MAP.containsKey(map)) {
            return AVAILABLE_MAP.get(map);
        }
        return null;
    }
}
