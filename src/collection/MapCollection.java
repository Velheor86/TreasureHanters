package collection;

import Abstracts.AbstractGameObject;
import Abstracts.AbstractMoveObject;
import Objects.Coordinate;
import enums.GameObjectType;
import enums.MoveAction;
import enums.MovingDirect;
import interfaces.map.GameCollection;
import Objects.Nothing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;


public class MapCollection implements GameCollection {


    private HashMap<Coordinate, AbstractGameObject> gameObject = new HashMap();
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> objectType = new EnumMap(GameObjectType.class);

    @Override
    public void addGameObject(AbstractGameObject newObject) {
        ArrayList<AbstractGameObject> temp = objectType.get(newObject.getType());
        if (temp == null) {
            temp = new ArrayList();
        }
        temp.add(newObject);

        gameObject.put(newObject.getCoordinate(), newObject);
        objectType.put(newObject.getType(), temp);
    }


    @Override
    public ArrayList<AbstractGameObject> getGameObject(GameObjectType type) {
        return objectType.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return gameObject.get(coordinate);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObject.get(new Coordinate(x, y));
    }

    @Override
    public HashMap<Coordinate, AbstractGameObject> getGameObject() {
        return gameObject;
    }

    @Override
    public MoveAction moveObject(MovingDirect direct, GameObjectType type) {
            MoveAction action = null;
        for (AbstractGameObject gameObject : this.getGameObject(type)) {
            if (gameObject instanceof AbstractMoveObject) {

                AbstractGameObject secondGameObject = getObjectByCoordinate(getNewCoordinate(direct,gameObject));

                switch (((AbstractMoveObject) gameObject).move(secondGameObject)){
                    case DIE:
                    {
                        action = MoveAction.DIE;
                        break;
                    }
                    case COLLECT:{
                        swapObject(gameObject,new Nothing(getNewCoordinate(direct,gameObject)));
                        break;
                    }
                    case MOVING:{
                        swapObject(gameObject,secondGameObject);
                        break;
                    }
                    case EXIT:{

                    }
                    case STAY: {
                        action = MoveAction.STAY;
                        break;
                    }
                }
                ((AbstractMoveObject) gameObject).changeIcon(direct,type);
            }
        }
        return action;
    }

    private void swapObject(AbstractGameObject firstObject, AbstractGameObject secondObject) {
        Coordinate coordinate = firstObject.getCoordinate();
        firstObject.setCoordinate(secondObject.getCoordinate());
        secondObject.setCoordinate(coordinate);
        gameObject.put(firstObject.getCoordinate(),firstObject);
        gameObject.put(secondObject.getCoordinate(),secondObject);

    }

    public Coordinate getNewCoordinate(MovingDirect direct, AbstractGameObject object) {

        int x = object.getCoordinate().getX();
        int y = object.getCoordinate().getY();
        Coordinate newcoord = new Coordinate(x,y);


        switch (direct) {

            case UP: {
                newcoord.setY(newcoord.getY() - 1);
                break;
            }
            case LEFT: {
                newcoord.setX(newcoord.getX() - 1);
                break;
            }
            case DOWN: {
                newcoord.setY(newcoord.getY() + 1);
                break;
            }
            case RIGHT: {
                newcoord.setX(newcoord.getX() + 1);
                break;
            }

        }
        return newcoord;
    }


}
