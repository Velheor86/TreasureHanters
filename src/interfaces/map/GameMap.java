package interfaces.map;


public interface GameMap {

    int getHeight();

    int getWight();

    boolean loadMap(Object source);

    boolean saveMap(Object source);

    int getLimit();
}

