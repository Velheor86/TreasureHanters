package interfaces.map;

import Abstracts.AbstractGameObject;
import Objects.Coordinate;
import enums.GameObjectType;
import enums.MoveAction;
import enums.MovingDirect;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Admin on 10.02.2016.
 */
public interface GameCollection {

    void addGameObject(AbstractGameObject newObject);
    ArrayList<AbstractGameObject> getGameObject(GameObjectType type);
    AbstractGameObject getObjectByCoordinate(Coordinate coordinate);
    AbstractGameObject getObjectByCoordinate(int x, int y);
    HashMap<Coordinate, AbstractGameObject> getGameObject();
    MoveAction moveObject(MovingDirect direct, GameObjectType type);

}
