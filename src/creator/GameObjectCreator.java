package creator;

import Abstracts.AbstractGameObject;
import Objects.*;
import enums.GameObjectType;

/**
 * Created by Admin on 03.02.2016.
 */
public class GameObjectCreator {

    private static GameObjectCreator inst;

    public static GameObjectCreator getInst() {
        if (inst == null)
            inst = new GameObjectCreator();
        return inst;
    }

    public AbstractGameObject createObject(GameObjectType type, Coordinate coordinate){
            AbstractGameObject obj=null;

        switch (type){
            case EXIT: {
                obj = new Exit(coordinate);
                break;
            }
            case NOTHING: {
                obj = new Nothing(coordinate);
                break;
            }
            case MONSTER: {
                obj = new Demon(coordinate);
                break;
            }
            case WALL: {
                obj = new Wall(coordinate);
                break;
            }
            case HEROE: {
                obj = new Heroe(coordinate);
                break;
            }
            case TREASURE: {
                obj = new Treashure(coordinate);
                break;
            }
            default:throw new IllegalArgumentException("тип не определен");
        }
        return obj;
    }


}
