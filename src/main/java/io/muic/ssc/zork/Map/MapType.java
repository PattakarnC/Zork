package io.muic.ssc.zork.Map;

public enum MapType {
    TESTMAP(TestMap.class, "Test Map", "A map for testing purpose.");

    private Class<? extends Map> mapClass;
    private String mapName;
    private String mapDescription;

    MapType(Class<? extends Map> mapClass, String mapName, String mapDescription) {
        this.mapClass = mapClass;
        this.mapName = mapName;
        this.mapDescription = mapDescription;
    }

    public Class<? extends Map> getMapClass() {
        return mapClass;
    }

    public String getMapName() {
        return mapName;
    }

    public String getMapDescription() {
        return mapDescription;
    }
}
