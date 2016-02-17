package creator;

import Abstracts.AbstractGameMap;
import Abstracts.AbstractGameObject;
import collection.MapCollection;
import enums.MapSource;
import mapsources.FSMap;

/**
 * Created by Admin on 05.02.2016.
 */
public class MapCreator {

    private static  MapCreator jmap;

    public static MapCreator getJmap(){
        if (jmap == null)
            jmap = new MapCreator();
        return jmap;
    }

    public AbstractGameMap createMap(MapSource type, MapCollection collection){
        AbstractGameMap map = null;

        switch (type){
            case FS:
            {
                map = new FSMap(collection);
                break;
            }

        }
        return map;
    }

}
