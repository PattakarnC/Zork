package io.muic.ssc.zork.Map;

public enum MapType {
    TRAIN_GRAVEYARD(TrainGraveyard.class, "Train Graveyard"),
    CORNEO_COLOSSEUM(CorneoColosseum.class, "Corneo Colosseum");

    private Class<? extends Map> mapClass;
    private String mapName;
    private String mapDescription;

    MapType(Class<? extends Map> mapClass, String mapName) {
        this.mapClass = mapClass;
        this.mapName = mapName;
    }

    public Class<? extends Map> getMapClass() {
        return mapClass;
    }

    public String getMapName() {
        return mapName;
    }
}
